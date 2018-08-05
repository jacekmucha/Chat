package chat.Controller;

import chat.ChatServer.ChatServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    GridPane loginGridPane;

    @FXML
    Button signInButton;

    @FXML
    Label userName;

    @FXML
    public void getUserNameAndOpenChat(ActionEvent actionEvent) throws IOException {

    String newUserName = userName.getText();

    openChatWindow();

    }

    private void openChatWindow(){
        FXMLLoader loadChatWindow = new FXMLLoader(getClass().getResource("/fxml/chatWindow.fxml"));
        Parent chatWindow = null;
        try {
            chatWindow = (Parent)loadChatWindow.load();
            Stage chatStage = new Stage();
            chatStage.setTitle("Super Mega Live Chat");
            chatStage.setScene(new Scene(chatWindow));
            chatStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void initialize(URL location, ResourceBundle resources) {

    }

    public void runServer(ActionEvent actionEvent) {

    }
}
