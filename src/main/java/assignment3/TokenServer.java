package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class TokenServer {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;
    private int totalTokens = 10;
    private static List<String> tokens;

    public static List<String> getTokens() {
        return tokens;
    }

    public static void setTokens(List<String> tokens) {
        TokenServer.tokens = tokens;
    }

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
                doService();
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void doService() throws IOException {

        while (true) {
            if (!scanner.hasNext()) {
                return;
            }

            String request = scanner.nextLine(); // why you no work?!
            System.out.println("Received message from client: " + request);

            // test for type of request

            handleTokenRequest(request);
        }
    }

    public void handleTokenRequest(String request) throws IOException {
        System.out.println("Received message from client: " + request);

        if (request.startsWith("SUBMIT")) {
            System.out.println(request.split(" ")[1]);
//            String token = request.split(" ")[1];
//            if (tokens.size() == totalTokens) {
//                writer.println("ERROR");
//            } else {
//                tokens.add(token);
//            }
        } else if (request.startsWith("RETRIEVE")) {
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
