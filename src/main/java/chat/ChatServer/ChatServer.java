package chat.ChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private static final Integer PORT = 2345;
    static List<Socket> sockets = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            System.out.println("Server waiting for Client... ");
            //przyjmowanie połączeń TCP
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                sockets.add(clientSocket);
                ChatServerThreadService threadService = new ChatServerThreadService(clientSocket);

                //tworzenie nowego watku
                Thread thread = new Thread(threadService);
                thread.start();
            }


        } catch (IOException e) {
            System.err.println("Cannot create server instance");
            e.printStackTrace();
        }
    }


}
