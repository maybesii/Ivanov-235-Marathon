package pr.ivanov.example.controller;

import javafx.event.ActionEvent;

import static pr.ivanov.example.util.Manager.showStage;

public class SecondController {
    public void goToFirstPage(ActionEvent actionEvent) {
        showStage("main-view.fxml" , "Maraphon Skills 2016");
    }
}
