
// Client Side
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // the client assumes that the server is listening for connection request on
            // port server via TCP
            int serverPort = 2050;
            InetAddress host = InetAddress.getByName("localhost");
            System.out.println("Command has been executed on port " + serverPort);

            Socket socket = new Socket(host, serverPort);
            // Socket socket = new Socket("127.0.0.1", serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            //
            PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // The client creates an input stream to receive data from its socket and an
            // outputstream
            // to send data to the socket at the server's end of the channel
            toServer.println("Hello from " + socket.getLocalSocketAddress());
            String line = fromServer.readLine();
            System.out.println("Client received: " + line + " from Server");
            toServer.close();
            fromServer.close();
            socket.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            // The socket constructor throws an IOException if its can not make a connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}