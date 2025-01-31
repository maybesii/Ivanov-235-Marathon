package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pr.ivanov.task.util.MarathonTimer;

import java.time.LocalDateTime;

import static pr.ivanov.task.util.Manager.showStage;

public class MainController {

    @FXML
    private Label marathonLabel;

    private MarathonTimer marathonTimer;

    public void initialize() {
        // year , month , numMonth , HH , MM
        LocalDateTime marathonTime = LocalDateTime.of(2025, 2, 4, 9, 0);
        marathonTimer = new MarathonTimer(marathonLabel, marathonTime);
    }

    public void onClickExchange(ActionEvent actionEvent) {
        showStage("exchange-view.fxml", "Marathon Skills 2016 - Register as a runner");
    }
}