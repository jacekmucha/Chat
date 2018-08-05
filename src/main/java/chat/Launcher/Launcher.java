package chat.Launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Launcher extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loaderLoginWindow = new FXMLLoader(this.getClass().getResource("/fxml/loginWindow.fxml"));
        GridPane loginWindow = loaderLoginWindow.load();

        Scene loginScene = new Scene(loginWindow);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Super Mega Live Chat");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
