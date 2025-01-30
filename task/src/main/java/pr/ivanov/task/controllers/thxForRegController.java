package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;

import static pr.ivanov.task.util.Manager.*;

public class thxForRegController {
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
}
