
// Server side
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] agrs) {

        try {
            int serverPort = 2000;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            serverSocket.setSoTimeout(1000);
            serverSocket.close();
            while (true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                // The server calls accepts() method of the serverSocket inorder to listen for
                // incoming connetion
                // requests from clients
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                // The server gets input and output streams from the socket and use them to
                // communicate
                // with the client
                PrintWriter toClient = new PrintWriter(server.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(server.getInputStream()));
                String line = fromClient.readLine();
                System.out.println("Server received: " + line);
                toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nNiceMoment!");

            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            // the socket constructor throws an IOException if its cannot make a connection
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
