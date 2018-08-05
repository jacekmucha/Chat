package chat.ChatClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String HOST_NAME = "localhost";
    private static final Integer PORT = 2345;
    private static ChatClientThreadSevice threadSevice;


    public static void main(String[] args) {
        Socket clientSocket = null;

        {
            try {
                clientSocket = new Socket(HOST_NAME, PORT);
                threadSevice = new ChatClientThreadSevice(clientSocket);
                Thread thread = new Thread(threadSevice);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Wyślij wiadomość");
            threadSevice.sendMessage(SCANNER.nextLine());
    }

    }






}
