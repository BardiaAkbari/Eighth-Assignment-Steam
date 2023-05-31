package Shared;

import Client.Client;
import Client.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Request {

    // Attributes
    private Scanner input;
    private PrintWriter output;
    private JSONObject jsonObject;

    // Constructor
    public Request(Scanner input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    // Exit From App
    public void exitFromApp() {
        System.exit(1);
    }

    public boolean usernameCheckingRequest(String username) {
        String jsonCommand = "{\"number\" : \"1\" , \"username\" : " + '"' + username + "\"}" ;
        output.println(jsonCommand);
        output.flush();
        String answer = input.nextLine();
        jsonObject = new JSONObject(answer);
        return Boolean.parseBoolean(jsonObject.getString("answer"));
    }

    public Client checkPasswordForLoginOperation (String username, String password) throws IOException {
        String jsonCommand = "{\"number\" : \"2\" , \"username\" : " + '"' + username + '"' + " , \"password\" : " + '"' + password + "\"}";
        output.println(jsonCommand);
        output.flush();
        String answer = input.nextLine();
        return new ObjectMapper().readValue(answer, Client.class);
    }

    public String addUserToDB(Client client) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(client);
        String jsonCommand = "{\"number\" : \"3\" , \"client\" : " + jsonData + '}';
        output.println(jsonCommand);
        output.flush();
        return input.nextLine();
    }

    public boolean checkGameExist(String gameName) {
        boolean flag = false;
        String jsonCommand = "{\"number\" : \"4\" , \"gameName\" : \"" + gameName + "\"}";
        output.println(jsonCommand);
        output.flush();
        String answer = input.nextLine();
        if (answer.equals("1")) {
            flag = true;
        }
        return flag;
    }

    public JSONObject showGameInfo(String gameName) {
        String jsonCommand = "{\"number\" : \"5\" , \"gameName\" : \"" + gameName + "\"}";
        output.println(jsonCommand);
        output.flush();
        return new JSONObject(input.nextLine());
    }

    public String downloadGame(String clientID, String gameName) {
        String jsonCommand = "{\"number\" : \"6\" , \"gameName\" : \"" + gameName + "\", \"clientID\" : \"" + clientID + "\"}";
        output.println(jsonCommand);
        output.flush();
        return input.nextLine();
    }
}