package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pr.ivanov.task.util.MarathonTimer;

import java.time.LocalDateTime;

import static pr.ivanov.task.util.Manager.*;

public class thxForRegController {
    @FXML
    private Label marathonLabel;

    private MarathonTimer marathonTimer;

    public void onClickCancel(ActionEvent actionEvent) {
        showStage(previousPageFXML, previousPageTitle);
    }

    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "thxForReg-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Registration confirmation";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }

    public void onClickOK(ActionEvent actionEvent) {
        showStage("runnerMenu-view.fxml", "Marathon Skills 2016 - Runner Menu");
    }

    public void initialize() {
        // year , month , numMonth , HH , MM
        LocalDateTime marathonTime = LocalDateTime.of(2025, 2, 4, 9, 0);
        marathonTimer = new MarathonTimer(marathonLabel, marathonTime);
    }
}
