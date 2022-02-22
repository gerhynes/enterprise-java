package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class TokenServer {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;
    private int maxTokens = 10;
    private static ArrayList<String> tokens = new ArrayList<String>();

    public static String getTokensAsString() {
        String tokenStr = "";
        for (String token : tokens) {
            tokenStr += token + " ";
        }
        return tokenStr;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        TokenServer serverInstance = new TokenServer();

        System.out.println("Server running. Waiting for a client to connect.");

        while (true) {
            serverInstance.socket = server.accept();
            System.out.println("Client connected");
            serverInstance.run();

            System.out.println("Client disconnected. Waiting for a new client to connect.");
        }
    }

    public void run() {
        try {
            try {
                scanner = new Scanner(socket.getInputStream());
                writer = new PrintWriter(socket.getOutputStream());
                handleRequest();
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void handleRequest() throws IOException {
        while (true) {
            if (!scanner.hasNext()) {
                return;
            }

            String request = scanner.nextLine();
            System.out.println("Received message from client: '" + request + "'");

            // Check type of submission
            if (request.startsWith("SUBMIT")) {
                String token = request.split(" ")[1];
                handleSubmit(token);
            } else if (request.startsWith("RETRIEVE")) {
                // Return tokens as strings with whitespace
                writer.println(getTokensAsString());
            } else if (request.startsWith("QUIT")) {
                // End connection to that client. No reply
                socket.close();
            } else {
                System.err.println("Unknown request");
            }
            writer.flush();
        }
    }

    public void handleSubmit(String token) {
        if (tokens.size() == maxTokens) {
            writer.println("ERROR");
        } else {
            tokens.add(token);
            writer.println("OK");
        }
    }
}
