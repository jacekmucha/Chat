package chat.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public void getUserNameAndOpenChat(ActionEvent actionEvent) throws IOException {

        FXMLLoader loadChatWindow = new FXMLLoader(getClass().getResource("/fxml/chatWindow.fxml"));
        Parent chatWindow = (Parent)loadChatWindow.load();
        Stage chatStage = new Stage();
        chatStage.setTitle("Super Mega Live Chat");
        chatStage.setScene(new Scene(chatWindow));
        chatStage.show();

    }


    public void initialize(URL location, ResourceBundle resources) {

    }
}