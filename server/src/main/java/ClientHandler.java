import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            boolean isReceivingMessages = true;
            while (isReceivingMessages) {
                String msg = dataInputStream.readUTF();
                if (msg.equals("exit")) {
                    isReceivingMessages = false;
                }
                System.out.println("Message: " + msg);
            }

            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Client handler error: " + e);
        }
    }
}
