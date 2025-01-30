package pr.ivanov.task.util;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pr.ivanov.task.HelloApplication;

import java.io.IOException;

public class Manager {
    public static Stage mainStage;
    public static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    public static String previousPageFXML = "main-view.fxml";
    public static String previousPageTitle = "Marathon Skills 2016";

    public static void showMainStage(Stage stage, String fxmlFileName, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/pr/ivanov/task/" + fxmlFileName));
        try {
            Scene scene = new Scene(fxmlLoader.load(), screenSize.getWidth(), screenSize.getHeight());
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/pr/ivanov/task/" + fxmlFileName));
        try {
            Scene scene = new Scene(fxmlLoader.load(), screenSize.getWidth(), screenSize.getHeight());
            mainStage.setScene(scene);
            mainStage.setTitle(title);
            mainStage.setMaximized(true);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}