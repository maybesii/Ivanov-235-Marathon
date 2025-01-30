package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static pr.ivanov.task.util.Manager.*;
import static pr.ivanov.task.util.Manager.showStage;

public class ExchangeController {

    public void onClickLogin(ActionEvent actionEvent) {
        previousPageFXML = "exchange-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register as a runner";
        showStage("login-view.fxml", "Marathon Skills 2016 - Login");
    }

    public void onClickRegister(ActionEvent actionEvent) {
        previousPageFXML = "exchange-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register as a runner";
        showStage("register-view.fxml", "Marathon Skills 2016 – Register as a runner");
    }


    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "exchange-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register as a runner";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }

    public void onClickCancel(ActionEvent actionEvent) {
        showStage(previousPageFXML, previousPageTitle);
    }
}
