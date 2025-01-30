package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static pr.ivanov.task.util.Manager.showStage;

public class MainController {

    @FXML
    public void initialize() {
    }

    public void onClickExchange(ActionEvent actionEvent) {
        showStage("exchange-view.fxml", "Marathon Skills 2016 - Register as a runner");
    }
}