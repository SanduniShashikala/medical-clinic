package lk.ijse.dep9.clinic.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;

public class ManageFeildFormController {
    public Button btnSave;
    public Button btnNew;
    public Button btnDelete;
    public TextField txtInput;
    public ListView lblOutput;

    public void initialize(){
        Platform.runLater(txtInput::requestFocus);

    }


    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnNewOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
