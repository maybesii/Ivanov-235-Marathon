package pr.ivanov.task.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import static pr.ivanov.task.util.Manager.*;

public class RegisterMarathonController {
    private IntegerProperty paymentFinal = new SimpleIntegerProperty(0);

    @FXML
    ToggleGroup toggleGroup;

    @FXML
    private Label paymentFinalLB;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private ComboBox wherePaymentCB;

    @FXML
    private VBox radioBoxes;

    @FXML
    private VBox checkBoxes;

    public void onClickRegistration(ActionEvent actionEvent) {
        boolean er = false;
        if (!isAnySelectedCheckBox()) {
            checkBoxes.setStyle("-fx-border-color: red;");
            er = true;
        }
        if (!isAnySelectedRadio()) {
            radioBoxes.setStyle("-fx-border-color: red");
            er = true;
        }
        if (!er) {
            previousPageFXML = "registrationMarathon-view.fxml";
            previousPageTitle = "Marathon Skills 2016 - Register for an event";
            showStage("thxForReg-view.fxml", "Marathon Skills 2016 - Registration confirmation");
        }
    }

    public void onClickCancel(ActionEvent actionEvent) {
        previousPageFXML = "registrationMarathon-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register for an event";
        showStage("login-view.fxml", "Marathon Skills 2016 - Login");
    }

    @FXML
    public void initialize() {
        wherePaymentCB.setValue(wherePaymentCB.getItems().getFirst());
        toggleGroup = new ToggleGroup();
        option1.setToggleGroup(toggleGroup);
        option2.setToggleGroup(toggleGroup);
        option3.setToggleGroup(toggleGroup);

        option1.selectedProperty().addListener((_, oldValue, newValue) -> {
            radioBoxes.setStyle("");
        });

        option2.selectedProperty().addListener((_, oldValue, newValue) -> {
            if (newValue) {
                paymentFinal.set(paymentFinal.get() + 20);
            } else {
                paymentFinal.set(paymentFinal.get() - 20);
            }
            radioBoxes.setStyle("");
        });

        option3.selectedProperty().addListener((_, oldValue, newValue) -> {
            if (newValue) {
                paymentFinal.set(paymentFinal.get() + 45);
            }else {
                paymentFinal.set(paymentFinal.get() - 45);
            }
            radioBoxes.setStyle("");
        });

        checkBox1.selectedProperty().addListener((_, _, newValue) -> {
            if (newValue) {
                paymentFinal.set(paymentFinal.get() + 145);
            } else {
                paymentFinal.set(paymentFinal.get() - 145);
            }
            checkBoxes.setStyle("");
        });

        checkBox2.selectedProperty().addListener((_, _, newValue) -> {
            if (newValue) {
                paymentFinal.set(paymentFinal.get() + 75);
            } else {
                paymentFinal.set(paymentFinal.get() - 75);
            }
            checkBoxes.setStyle("");
        });

        checkBox3.selectedProperty().addListener((_, _, newValue) -> {
            if (newValue) {
                paymentFinal.set(paymentFinal.get() + 20);
            } else {
                paymentFinal.set(paymentFinal.get() - 20);
            }
            checkBoxes.setStyle("");
        });

        paymentFinal.addListener((_, _, newValue) -> {
            paymentFinalLB.setText("$" + newValue.toString());
        });
    }

    private boolean isAnySelectedCheckBox() {
        return checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected();
    }

    private boolean isAnySelectedRadio() {
        return toggleGroup.getSelectedToggle() != null;
    }

    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "registrationMarathon-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register for an event";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }
}
