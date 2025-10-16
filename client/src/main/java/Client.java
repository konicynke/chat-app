import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 6666);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            boolean isSending = true;

            while (isSending) {
                System.out.println("Enter message:");

                String msg = scanner.nextLine();
                if (msg.equals("exit")) {
                    isSending = false;
                }
                dataOutputStream.writeUTF(msg);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            scanner.close();

            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
