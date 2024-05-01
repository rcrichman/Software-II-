package srcCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchedulingMain extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(SchedulingMain.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Scheduling Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}