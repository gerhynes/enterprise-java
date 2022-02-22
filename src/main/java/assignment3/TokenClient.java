package assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TokenClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner reader = new Scanner(inputStream);
        Scanner userInput = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(outputStream);

        // Print instructions
        System.out.println("Enter one of these 3 commands:\n" +
                "SUBMIT token - sends token (word) to server\n" +
                "RETRIEVE - gets all tokens (words) from server\n" +
                "QUIT - ends programme\n" +
                "Press Enter to send command");

        while(true) {
            String request = userInput.nextLine();

            writer.print(request);
            System.out.println("Sent " + request + " to server");
            writer.flush();

            if(request.startsWith("QUIT")) {
                System.out.println("Quitting");
                socket.close();
                break;
            }

            String response = reader.nextLine();
            System.out.println("Received message from server: " + response);
        }
    }
}
