package assignment3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConversionClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);
        InputStream instream = s.getInputStream();
        OutputStream outstream = s.getOutputStream();
        Scanner in = new Scanner(instream);
        PrintWriter out = new PrintWriter(outstream);
        String request = "CONVERT_TO_KGS 123.45\n";
        out.print(request);
        out.flush();
        String response = in.nextLine();
        System.out.println("Receiving: " + response);
        s.close();
    }
}
