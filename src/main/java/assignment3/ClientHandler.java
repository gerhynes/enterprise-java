package assignment3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientHandler implements Runnable {
    // Instance variables
    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;
    private TokenServer server;
    // Assign ids in a thread-safe manner
    private int clientID;
    private static AtomicInteger totalClients = new AtomicInteger(0);

    public ClientHandler(TokenServer tokenServer, Socket clientSocket) throws IOException {
        // Set up socket and streams
        this.server = tokenServer;
        this.socket = clientSocket;
        scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        // Assign unique id to thread
        clientID = totalClients.incrementAndGet();
        System.out.println("Client" + clientID + " connected");
        try {
            handleRequest();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public void handleRequest() throws IOException {
        // Access token collection in thread-safe manner
        synchronized (server) {
            while (true) {
                if (!scanner.hasNext()) {
                    return;
                }

                String request = scanner.nextLine();
                System.out.println("Received message from client" + clientID + ": '" + request + "'");

                // Check for type of submission
                if (request.startsWith("SUBMIT")) {
                    // Insert first word after SUBMIT
                    String token = request.split(" ")[1];
                    handleSubmit(token);
                } else if (request.startsWith("RETRIEVE")) {
                    // Return tokens as strings with whitespace
                    writer.println(getTokensAsString());
                    System.out.println("Sent response '" + getTokensAsString() + "' to client" + clientID);
                } else if (request.startsWith("QUIT")) {
                    // End connection to that client. No reply
                    socket.close();
                } else {
                    System.err.println("Unknown request");
                }
                writer.flush();
                // Wake other threads
                server.notifyAll();
            }
        }
    }

    public void handleSubmit(String token) {
        // Ensure maxTokens not exceeded
        if (server.getTokens().size() == server.getMaxTokens()) {
            writer.println("ERROR");
            System.out.println("Send response 'ERROR' to client" + clientID);
        } else {
            server.getTokens().add(token);
            writer.println("OK");
            System.out.println("Sent response 'OK' to client" + clientID);
        }
    }

    // Create string representation of tokens
    public String getTokensAsString() {
        String tokenStr = "";
        for (String token : server.getTokens()) {
            tokenStr += token + " ";
        }
        return tokenStr.trim();
    }
}
