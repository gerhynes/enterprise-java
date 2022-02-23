package assignment3;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.TreeSet;

public class TokenServer {
    // Static variables
    private static TreeSet<String> tokens = new TreeSet<String>();
    private static int maxTokens = 10;

    // Methods for accessing token information
    public int getMaxTokens() {
        return maxTokens;
    }

    public static TreeSet<String> getTokens() {
        return tokens;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Server running. Waiting for a client to connect.");

        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                // Create server instance to reference from ClientHandler
                TokenServer serverInstance = new TokenServer();
                // Create thread for each client
                ClientHandler clientHandler = new ClientHandler(serverInstance, server.accept());
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        }
    }
}
