package Server;

import Shared.Response;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class ServerMain {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");
        while (true) {
            Socket myClient = server.accept();
            System.out.println("Client connected.");
            Response response = new Response();
            Service service = new Service(myClient, response);
            Thread clientThread = new Thread(service);
            clientThread.start();
        }
    }
}
