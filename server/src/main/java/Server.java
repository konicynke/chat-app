import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Starting server");

            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("Server started. Listening on port 6666");

            ExecutorService executor = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                ClientHandler clientHandler = new ClientHandler(socket);
                executor.submit(clientHandler);
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
