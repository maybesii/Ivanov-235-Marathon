package pr.ivanov.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static pr.ivanov.example.util.Manager.showStage;

public class MainController {

    @FXML
    protected void goToNextPage() {
        showStage("second-view.fxml" , "Maraphon Skills 2016");
    }

}
