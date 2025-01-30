package pr.ivanov.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static pr.ivanov.example.util.Manager.showMainStage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        showMainStage(stage , "main-view.fxml" , "Maraphon Skills 2016");
    }

    public static void main(String[] args) {
        launch();
    }
}