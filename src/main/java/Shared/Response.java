package Shared;

import Client.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

public class Response {

    Connection connection;
    Statement statement;


    public Response() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/steam",
                    "root",
                    "Nariman@1383");
        statement = connection.createStatement();
    }

    /* Public Functions*/

    // Input - Output Handel

    // Exiting
    public void ExitFromApp() {
        System.exit(1);
    }

    // Entering


    // Entering Operations
    public String checkUsernameExist(String username) throws SQLException {
        String sqlCommand = "SELECT count(*) FROM accounts WHERE username = " + '"' + username + '"';
        ResultSet checkUsernameResult = statement.executeQuery(sqlCommand);
        checkUsernameResult.next();
        int numberCheck = Integer.parseInt(checkUsernameResult.getString("count(*)"));
        boolean answer = numberCheck != 0;
        return "{\"answer\" : " + '"' + answer + "\"}";
    }

    public String checkPasswordForLoginOperation(String username, String password) throws SQLException, IOException {
        Client client = null;
        String sqlCommand = "SELECT id, birth_date, password FROM accounts WHERE username = " + '"' + username + '"';
        ResultSet checkForClientResult = statement.executeQuery(sqlCommand);
        checkForClientResult.next();
        String dbPassword = checkForClientResult.getString("password");
        if (dbPassword.equals(password)) {
            String id = checkForClientResult.getString("id");
            String birth_date = checkForClientResult.getString("birth_date");
            client = new Client(id, username, dbPassword, birth_date);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(client);
        return jsonData;
    }

    public String addUserToDB(JSONObject jsonObject) throws SQLException {
        String sqlCommand = "INSERT INTO accounts VALUES (\"" + jsonObject.getString("iD") + "\",\"" +
                jsonObject.getString("username") + "\",\"" + jsonObject.getString("password") + "\",\"" +
                jsonObject.getString("date") + "\")";
        int addUser = statement.executeUpdate(sqlCommand);
        return "";
    }

    public String checkGameExist(String gameName) throws SQLException {
        String sqlCommand = "SELECT COUNT(*) FROM games WHERE title = '" + gameName + "'";
        ResultSet gameExistence = statement.executeQuery(sqlCommand);
        gameExistence.next();
        return gameExistence.getString(1);
    }

    public String showGameInfo(String gameName) throws SQLException {
        String sqlCommand = "SELECT * FROM games WHERE title = '" + gameName + "'";
        ResultSet gameInfo = statement.executeQuery(sqlCommand);
        gameInfo.next();
        String answer = "{\"title\" : \"" + gameInfo.getString(2) +
                "\", \"developer\" : \"" + gameInfo.getString(3) + "\", \"genre\" : \"" +
                gameInfo.getString(4) + "\", \"price\" : \"" + gameInfo.getString(5) +
                "\", \"release year\" : \"" + gameInfo.getString(6) + "\", \"controller support\" : \"" +
                gameInfo.getString(7) + "\", \"reviews\" : \"" + gameInfo.getString(8) +
                "\", \"size\" : \"" + gameInfo.getString(9) + "\"}";

        return answer;
    }

    public String downloadGame(String gameName, String clientID) throws SQLException, IOException {
        String sqlCommand = "SELECT * FROM games WHERE title = '" + gameName + "'";
        ResultSet gameInfo = statement.executeQuery(sqlCommand);
        gameInfo.next();
        String gameID = gameInfo.getString("id");
        String mainTxtFile = "D:\\Uni TA Projects\\Term 2\\Java\\Main\\Eighth-Assignment-Steam\\src\\main\\java\\Server\\Resources\\" +
                gameID + ".txt";
        String mainPngFile = "D:\\Uni TA Projects\\Term 2\\Java\\Main\\Eighth-Assignment-Steam\\src\\main\\java\\Server\\Resources\\" +
                gameID + ".png";
        String targetFolder = "D:\\SteamDownloads\\" + clientID;
        File existenceFile = new File(targetFolder);
        File tFile = new File(mainTxtFile);
        File pFile = new File(mainPngFile);
        if (!existenceFile.exists()) {
            boolean creat = existenceFile.mkdir();
        }
        File targetTFile = new File(targetFolder + "\\" + gameID + ".txt");
        File targetPFile = new File(targetFolder + "\\" + gameID + ".png");
        Files.copy(tFile.toPath(), targetTFile.toPath());
        Files.copy(pFile.toPath(), targetPFile.toPath());
        String secondSqlCommand = "SELECT COUNT(*) FROM downloads WHERE account_id = '" + clientID + "' AND game_id = '" + gameID + "'";
        ResultSet check = statement.executeQuery(secondSqlCommand);
        check.next();
        if (Integer.parseInt(check.getString(1)) == 1) {
            String updateSqlCommand = "UPDATE downloads SET download_count = download_count + 1 WHERE account_id = '" + clientID + "' AND game_id = '" + gameID + "'";
            int updateSql = statement.executeUpdate(updateSqlCommand);
        }
        else {
            String insertSqlCommand = "INSERT INTO downloads VALUES ('" + clientID + "','" + gameID + "'," + 1 + ")";
            int insertSql = statement.executeUpdate(insertSqlCommand);
        }
        return "";
    }

    public String getGameID(String gameName) throws SQLException {
        String sqlCommand = "SELECT id FROM games WHERE title = '" + gameName + "'";
        ResultSet checkGameID = statement.executeQuery(sqlCommand);
        checkGameID.next();
        return checkGameID.getString(1);
    }
}

