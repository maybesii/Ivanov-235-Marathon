package pr.ivanov.task;

import javafx.application.Application;
import javafx.stage.Stage;


import static pr.ivanov.task.util.Manager.showMainStage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        showMainStage(stage, "main-view.fxml", "Marathon Skills 2016");
    }

    public static void main(String[] args) {
        launch();
    }
}