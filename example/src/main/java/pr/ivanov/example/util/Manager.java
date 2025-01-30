package pr.ivanov.example.util;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pr.ivanov.example.HelloApplication;

import java.io.IOException;

public class Manager {
    public static Stage mainStage;
    public static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    public static void showMainStage(Stage stage, String fxmlFileName, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/pr/ivanov/example/" + fxmlFileName));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setMaximized(true);
            mainStage = stage;
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showStage(String fxmlFileName, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/pr/ivanov/example/" + fxmlFileName));
        try {
            Scene scene = new Scene(fxmlLoader.load(), screenSize.getWidth() , screenSize.getHeight());
            mainStage.setScene(scene);
            mainStage.setTitle(title);
            mainStage.setMaximized(true);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}