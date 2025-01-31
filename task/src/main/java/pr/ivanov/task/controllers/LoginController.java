package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pr.ivanov.task.util.MarathonTimer;

import java.time.LocalDateTime;

import static pr.ivanov.task.controllers.User.*;
import static pr.ivanov.task.util.Manager.*;

public class LoginController {
    @FXML
    private TextField emailET;

    @FXML
    private TextField passwordET;

    @FXML
    private Label marathonLabel;

    private MarathonTimer marathonTimer;

    public void onClickCancel(ActionEvent actionEvent) {
        showStage(previousPageFXML, previousPageTitle);
    }

    public void onClickLogin(ActionEvent actionEvent) {
        if (!emailET.getText().equals(email)) {
            emailET.setText("");
            emailET.setPromptText("Неверная почта");
            emailET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18; ");
        }
        else if(!passwordET.getText().equals(password)) {
            passwordET.setText("");
            passwordET.setPromptText("Неверный пароль");
            passwordET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
        }

        if (passwordET.getText().equals(password) && emailET.getText().equals(email)) {
            previousPageFXML = "login-view.fxml";
            previousPageTitle = "Marathon Skills 2016 - Login";
            showStage("registrationMarathon-view.fxml", "Marathon Skills 2016 - Register for an event");
        }
    }


    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "login-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Login";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }

    public void initialize() {
        // year , month , numMonth , HH , MM
        LocalDateTime marathonTime = LocalDateTime.of(2025, 2, 4, 9, 0);
        marathonTimer = new MarathonTimer(marathonLabel, marathonTime);
    }
}
