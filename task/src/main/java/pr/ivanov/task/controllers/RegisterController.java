package pr.ivanov.task.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

import static pr.ivanov.task.util.Manager.*;

public class RegisterController {
    private final ObservableList<String> countries = FXCollections.observableArrayList("Россия", "США", "Япония", "Италия");
    private final ObservableList<String> sexes = FXCollections.observableArrayList("Мужской", "Женский");

    @FXML
    private ComboBox<String> countryCB;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TextField emailET;

    @FXML
    private Button findImageBtn;

    @FXML
    private TextField nameET;

    @FXML
    private TextField nameImageET;

    @FXML
    private TextField passwordET;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField passwordRepeatET;

    @FXML
    private ComboBox<String> sexCB;

    @FXML
    private TextField surnameET;

    @FXML
    void onClickCancel(ActionEvent event) {
        showStage(previousPageFXML , previousPageTitle);
    }

    @FXML
    void onClickRegistration(ActionEvent event) {
        boolean inCorrect = false;
        String email = emailET.getText();
        String password = passwordET.getText();
        String passwordRepeat = passwordRepeatET.getText();
        String name = nameET.getText();
        String nameImage = nameImageET.getText();
        String surname = surnameET.getText();
        String country = countryCB.getValue();
        String sex = sexCB.getValue();
        String birthDate = dateDP.getValue() != null ? dateDP.getValue().toString() : "";

        if (email.isEmpty()) {
            emailET.setText("");
            emailET.setPromptText("Поле не должно быть пустым");
            emailET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
            inCorrect = true;
        }
        if (country == null || country.isEmpty()) {
            countryCB.setValue("");
            countryCB.setPromptText("Поле не должно быть пустым");
            countryCB.setStyle("-fx-text-fill: #f56e64; -fx-font-size: 18; -fx-border-color: red");
            inCorrect = true;
        }
        if (birthDate.isEmpty()) {
            dateDP.setStyle("-fx-text-fill: #f56e64; -fx-font-size: 18; -fx-border-color: red");
            inCorrect = true;
        }
        if (sex == null || sex.isEmpty()) {
            sexCB.setValue("");
            sexCB.setPromptText("Поле не должно быть пустым");
            sexCB.setStyle("-fx-text-fill: #f56e64; -fx-font-size: 18; -fx-border-color: red");
            inCorrect = true;
        }
        if (password.isEmpty()) {
            passwordET.setText("");
            passwordET.setPromptText("Поле не должно быть пустым");
            passwordET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
            inCorrect = true;
        }
        if (passwordRepeat.isEmpty()) {
            passwordRepeatET.setText("");
            passwordRepeatET.setPromptText("Поле не должно быть пустым");
            passwordRepeatET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
            inCorrect = true;
        }
        if (name.isEmpty()) {
            nameET.setText("");
            nameET.setPromptText("Поле не должно быть пустым");
            nameET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
            inCorrect = true;
        }
        if (surname.isEmpty()) {
            surnameET.setText("");
            surnameET.setPromptText("Поле не должно быть пустым");
            surnameET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");
            inCorrect = true;
        }


        if (!password.equals(passwordRepeat)) {
            passwordRepeatET.setText("");
            passwordRepeatET.setPromptText("Пароли должны совпадать");
            passwordRepeatET.setStyle("-fx-prompt-text-fill: #f56e64; -fx-font-size: 18");

        }
        if (!inCorrect) {
            User.email = email;
            User.password = password;
            User.name = name;
            User.surname = surname;
            User.country = country;
            User.sex = sex;
            User.birthDate = birthDate;
            previousPageFXML = "register-view.fxml";
            previousPageTitle = "Marathon Skills 2016 – Register as a runner";
            showStage("login-view.fxml", "Marathon Skills 2016 - Login");
        }

    }



    @FXML
    public void initialize() {
        countryCB.setItems(countries);
        sexCB.setItems(sexes);

        countryCB.setEditable(true);

        countryCB.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            filterComboBox(countryCB, countries, newValue);
        });
    }

    private void filterComboBox(ComboBox<String> comboBox, ObservableList<String> originalList, String filter) {
        ObservableList<String> filteredList = FXCollections.observableArrayList();

        if (filter.isEmpty()) {
            comboBox.setItems(originalList);
            comboBox.setValue("");
            return;
        }

        for (String item : originalList) {
            if (item.toLowerCase().contains(filter.toLowerCase())) {
                filteredList.add(item);
            }
        }

        comboBox.setItems(filteredList);

        comboBox.getEditor().setText(filter);
        comboBox.getEditor().positionCaret(filter.length());

        if (!filteredList.isEmpty()) {
            comboBox.show();
        }
    }

    @FXML
    void onClickFindImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp"));

        File selectedFile = fileChooser.showOpenDialog(findImageBtn.getScene().getWindow());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            nameImageET.setText(selectedFile.getName());
        }
    }

    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "register-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Register as a runner";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }
}
