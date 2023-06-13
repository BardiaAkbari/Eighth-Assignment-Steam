package Client;

import Shared.Request;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Question {

    // Attributes
    Request request;
    Scanner myScanner;

    // Constructor
    public Question(Request request, Scanner myScanner) {
        this.request = request;
        this.myScanner = myScanner;
    }

    // Public Functions
    public void showingEnteringMenu() throws IOException {
        System.out.println("Enter your command: ");
        System.out.println("1-Go and continue");
        System.out.println("2-Exit");
        int answer = Integer.parseInt(myScanner.nextLine());
        switch (answer) {
            case 1:
                accountExisting();
                break;
            case 2:
                request.exitFromApp();
                break;
            default:
                System.out.println("Please give us right answer.");
                showingEnteringMenu();
                break;
        }
    }

    public void accountExisting() throws IOException {
        System.out.println("Do you have an account?!(Yes/No): ");
        String answer = myScanner.nextLine();
        switch (answer) {
            case "yes":
            case "Yes":
                loginOperation();
                break;
            case "no":
            case "No":
                signupOperation();
                break;
            default:
                System.out.println("Please give us right answer.");
                accountExisting();
        }
    }

    public void loginOperation() throws IOException {
        System.out.println("Please enter you username: ");
        String username = myScanner.nextLine();
        if (request.usernameCheckingRequest(username)) {
            System.out.println("Please enter your password: ");
            String password = myScanner.nextLine();
            Client client = request.checkPasswordForLoginOperation(username, password);
            if (client != null) {
                mainMenu(client);
            }
            else {
                System.out.println("Your password is wrong.");
                System.out.println("Please enter right one.");
                loginOperation();
            }
        }
        else {
            System.out.println("Your username does not exist.");
            System.out.println("Please try again.");
            loginOperation();
        }
    }

    public void signupOperation() throws IOException {
        System.out.println("Please enter your username: ");
        String username = myScanner.nextLine();
        if (!request.usernameCheckingRequest(username)) {
            System.out.println("Please enter your password: ");
            String password = myScanner.nextLine();
            System.out.println("Please enter your birth date with this arrangement (YYYY-MM-DD): ");
            String date = myScanner.nextLine();
            Client client = new Client(username, password, date);
            String ans = request.addUserToDB(client);
            System.out.println(ans);
            mainMenu(client);
        }
        else {
            System.out.println("This username is already exist.");
            System.out.println("Please try again.");
            signupOperation();
        }
    }

    // Main Menu

    public void mainMenu(Client client) {
        System.out.println("What do you want to do?!");
        System.out.println("1-Browse the available video games");
        System.out.println("2-View each individual game's details");
        System.out.println("3-Download video game");
        int answer = Integer.parseInt(myScanner.nextLine());
        userDecideFromMainMenu(client, answer);
    }

    public void userDecideFromMainMenu(Client client, int answer) {
        switch (answer) {
            case 1:
                gameExistence(client);
                break;
            case 2:
                downloadAsk(client);
                break;
        }
    }

    public void gameExistence(Client client) {
        System.out.println("Please enter name of video game that you want: ");
        String videoGameName = myScanner.nextLine();
        if (request.checkGameExist(videoGameName)) {
            gameInfo(client, videoGameName);
        }
        else {
            System.out.println("There is not any game with this name.");
            System.out.println("Please try again");
            gameExistence(client);
        }
    }

    public void gameInfo(Client client, String gameName) {
        JSONObject gameInfo = request.showGameInfo(gameName);
        System.out.println("Title : " + gameInfo.getString("title"));
        System.out.println("Developer : " + gameInfo.getString("developer"));
        System.out.println("Genre : " + gameInfo.getString("genre"));
        System.out.println("Price : " + gameInfo.getString("price"));
        System.out.println("Release Year : " + gameInfo.getString("release year"));
        System.out.println("Controller Support : " + gameInfo.getString("controller support"));
        System.out.println("Reviews : " + gameInfo.getString("reviews"));
        System.out.println("Size : " + gameInfo.getString("size"));
        System.out.println("Do you want to download it?!(Yes/No): ");
        String answer = myScanner.nextLine();
        if (answer.equals("Yes") || answer.equals("yes")) {
            checkForExistenceOnPC(client, gameName);
            downloadGame(client, gameName);
        }
        else {
            mainMenu(client);
        }
    }

    public void downloadGame(Client client, String gameName) {
        String ans = request.downloadGame(client.getiD(), gameName);
        System.out.println(ans);
        System.out.println("This game is added to your D:\\ drive in your id name folder.");
        mainMenu(client);
    }

    public void downloadAsk(Client client) {
        System.out.println("Please enter name of video game that you want to download: ");
        String videoGameName = myScanner.nextLine();
        if (request.checkGameExist(videoGameName)) {
            checkForExistenceOnPC(client, videoGameName);
            downloadGame(client, videoGameName);
        }
        else {
            System.out.println("There is not any game with this name.");
            System.out.println("Please try again.");
            downloadAsk(client);
        }
    }

    public void checkForExistenceOnPC(Client client, String gameName) {
        String gameID = request.getGameID(gameName);
        String targetFolder = "D:\\SteamDownloads\\" + client.getiD() + "\\" + gameID + ".txt";
        File file = new File(targetFolder);
        if (file.exists()) {
            System.out.println("You already have this game.");
            mainMenu(client);
        }
    }
}