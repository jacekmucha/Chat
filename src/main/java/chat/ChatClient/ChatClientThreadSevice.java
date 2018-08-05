package chat.ChatClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientThreadSevice implements Runnable {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ChatClientThreadSevice(Socket socket) {
        try {
            this.socket = socket;
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        writer.println(message);
        writer.flush();
        //ustawienie TextFielda na focus -> już w buttonie
    }



//    @Override
    public void run() {
        try {

            while (true) {
                //do TextArea:
                String message;
                if ((message = reader.readLine()) != null) {
                    //TextArea.appendText...
                    System.out.println(message);
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
                e.printStackTrace();
            }

        }
    }
}
