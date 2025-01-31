package pr.ivanov.task.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pr.ivanov.task.util.MarathonTimer;

import java.time.LocalDateTime;

import static pr.ivanov.task.util.Manager.*;

public class runnerMenuController {

    @FXML
    private Label marathonLabel;

    private MarathonTimer marathonTimer;

    public void onClickCancel(ActionEvent actionEvent) {
        // year , month , numMonth , HH , MM
        LocalDateTime marathonTime = LocalDateTime.of(2025, 2, 4, 9, 0);
        marathonTimer = new MarathonTimer(marathonLabel, marathonTime);

        previousPageFXML = "runnerMenu-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Runner Menu";
        showStage("thxForReg-view.fxml", "Marathon Skills 2016 - Registration confirmation");
    }

    public void goToHome(ActionEvent actionEvent) {
        previousPageFXML = "runnerMenu-view.fxml";
        previousPageTitle = "Marathon Skills 2016 - Runner Menu";
        showStage("main-view.fxml", "Marathon Skills 2016");
    }

    public void onClickcontacts(ActionEvent actionEvent) {
        Stage contactStage = new Stage();
        contactStage.initStyle(StageStyle.UNDECORATED);
        contactStage.initModality(Modality.APPLICATION_MODAL);

        VBox vbox = new VBox(15);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10;");

        Label titleLabel = new Label("Контакты");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label infoLabel = new Label("Для получения дополнительной информации пожалуйста свяжитесь с координаторами");
        infoLabel.setStyle("-fx-alignment: center-left;");

        Text phoneText = new Text("Телефон: ");
        phoneText.setStyle("-fx-font-weight: bold;");
        Text phoneValue = new Text("+55 11 9988 7766");

        Text emailText = new Text("Email: ");
        emailText.setStyle("-fx-font-weight: bold;");
        Text emailValue = new Text("coordinators@marathonskills.org");

        HBox phoneHBox = new HBox(phoneText, phoneValue);
        phoneHBox.setAlignment(Pos.CENTER_LEFT);

        HBox emailHBox = new HBox(emailText, emailValue);
        emailHBox.setAlignment(Pos.CENTER_LEFT);

        // Добавляем отступы к элементам
        VBox.setMargin(infoLabel, new Insets(10, 0, 10, 0));
        VBox.setMargin(phoneHBox, new Insets(10, 0, 10, 0));
        VBox.setMargin(emailHBox, new Insets(10, 0, 10, 0));

        vbox.getChildren().addAll(titleLabel, infoLabel, phoneHBox, emailHBox);

        Scene scene = new Scene(vbox, 300, 150);
        contactStage.setScene(scene);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        contactStage.setWidth(primaryStage.getWidth() * 0.35);
        contactStage.setHeight(primaryStage.getHeight() * 0.35);

        contactStage.setX(primaryStage.getX() + (primaryStage.getWidth() - contactStage.getWidth()) / 2);
        contactStage.setY(primaryStage.getY() + (primaryStage.getHeight() - contactStage.getHeight()) / 2);

        contactStage.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getTarget() instanceof VBox) {
                contactStage.close();
            }
        });

        contactStage.showAndWait();
    }

}
