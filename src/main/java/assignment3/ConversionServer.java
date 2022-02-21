package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConversionServer {
    private Socket s;
    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        ConversionServer serverInstance = new ConversionServer();

        System.out.println("Server running. Waiting for a client to connect...");

        while(true){
            serverInstance.s = server.accept();
            System.out.println("Client connected");
            serverInstance.run();

            System.out.println("Client disconnected. Waiting for a new client to connect...");
        }
    }

    public void run() {
        try {
            try {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            } finally {
                s.close();
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    public void doService() throws IOException {
        while(true){
            if(!in.hasNext()) {
                return;
            }
            String request = in.next();
            System.out.println("Request received: " + request);

            // test for type of request

            handleConversionRequest(request);
        }
    }

    public void handleConversionRequest(String request) {
        String amountStr = in.next();
        double amount = Double.valueOf(amountStr);
        System.out.println("Received from client: " + amount);

        if(request.equals("CONVERT_TO_POUNDS")) {
            out.println(amount * 2.2d); // server response
            System.out.println("Sending conversion result to client");
        } else if (request.equals("CONVERT_TO_KGS")) {
            out.println(amount / 2.2d); // server response
            System.out.println("Sending conversion result to client");
        } else
            System.err.println("Unknown request");
        out.flush();
    }
}
