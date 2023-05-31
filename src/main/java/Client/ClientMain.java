package Client;

import Shared.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {

        final int PORT = 8888;
        try {
            Socket socket = new Socket("localhost", PORT);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner input = new Scanner(inputStream);
            PrintWriter output = new PrintWriter(outputStream);
            Scanner myScanner = new Scanner(System.in);
            Request request = new Request(input, output, myScanner);
            Question question = new Question(request, myScanner);
            request.setQuestion(question);
            question.showingEnteringMenu();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
