module pr.ivanov.example {
    requires javafx.controls;
    requires javafx.fxml;


    opens pr.ivanov.example to javafx.fxml;
    exports pr.ivanov.example;
    exports pr.ivanov.example.controller;
    opens pr.ivanov.example.controller to javafx.fxml;
}