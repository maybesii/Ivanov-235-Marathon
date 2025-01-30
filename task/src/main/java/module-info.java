module pr.ivanov.task {
    requires javafx.controls;
    requires javafx.fxml;


    opens pr.ivanov.task to javafx.fxml;
    exports pr.ivanov.task;
    exports pr.ivanov.task.controllers;
    opens pr.ivanov.task.controllers to javafx.fxml;
}