package Server;

import Shared.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class Service implements Runnable {

    // Attributes
    private Socket socket;
    private Scanner input;
    private PrintWriter outPut;
    private Response response;


    public Service(Socket socket, Response response) {
        this.socket = socket;
        this.response = response;
    }

    @Override
    public void run() {
        try {
            try {
                this.input = new Scanner(socket.getInputStream());
                this.outPut = new PrintWriter(socket.getOutputStream());
                doService();
            } finally {
                socket.close();
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doService() throws SQLException, IOException {
        while (true) {
            if (!input.hasNext()) {
                return;
            }
            String command = input.next();
            JSONObject jsonObject = new JSONObject(command);
            int number = Integer.parseInt(jsonObject.getString("number"));
            executeCommand(number, jsonObject);
        }
    }

    // Getting Answer

    public void executeCommand(int number, JSONObject jsonObject) throws SQLException, IOException {
        String answer = null;
        switch (number) {
            case 1:
                answer = response.checkUsernameExist(jsonObject.getString("username"));
                break;
            case 2:
                answer = response.checkPasswordForLoginOperation(jsonObject.getString("username"),
                        jsonObject.getString("password"));
                break;
            case 3:
                answer = response.addUserToDB(jsonObject.getJSONObject("client"));
                break;
            case 4:
                answer = response.checkGameExist(jsonObject.getString("gameName"));
                break;
            case 5:
                answer = response.showGameInfo(jsonObject.getString("gameName"));
                break;
            case 6:
                answer = response.downloadGame(jsonObject.getString("gameName"), jsonObject.getString("clientID"));
                break;
        }
        outPut.println(answer);
        outPut.flush();
    }
}
