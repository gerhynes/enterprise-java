package assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TokenClient {
    public static void main(String[] args) throws IOException {
        // Establish socket and streams
        Socket socket = new Socket("localhost", 8080);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner reader = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        Scanner userInput = new Scanner(System.in);

        // Print instructions
        System.out.println("Enter one of these three commands:\n" +
                "SUBMIT token - sends token (word) to server\n" +
                "RETRIEVE - gets all tokens (words) from server\n" +
                "QUIT - ends programme\n" +
                "Press Enter to send command\n");

        while(true) {
            // Take in request message
            String request = userInput.nextLine();

            // Send request message
            writer.println(request);
            System.out.println("Sent '" + request + "' to server");
            writer.flush();

            // Handle QUIT message
            if(request.startsWith("QUIT")) {
                System.out.println("Quitting");
                socket.close();
                userInput.close();
                break;
            }

            // Take in response message
            String response = reader.nextLine();
            System.out.println("Received message from server: '" + response + "'");
        }
    }
}
