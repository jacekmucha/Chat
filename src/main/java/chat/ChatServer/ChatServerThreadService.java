package chat.ChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerThreadService implements Runnable {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ChatServerThreadService(Socket socket) {

        try {
            this.socket = socket;
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Override
    public void run() {
        try {
            while (true){
                String message;
                if((message = reader.readLine()) != null){
                    for(Socket s : ChatServer.sockets){
                        PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                        printWriter.println(message);
                        printWriter.flush();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                writer.close();
                reader.close();
            } catch (IOException e) {
                System.err.print("Can not close streams!");
                e.printStackTrace();
            }

        }

    }
}
