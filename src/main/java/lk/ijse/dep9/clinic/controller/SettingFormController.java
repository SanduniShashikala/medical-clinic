package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SettingFormController {
    public AnchorPane pngContainer;
    public Button btnManagePrice;
    public Button btnAddDiscount;
    public Button btnManageFeild;
    public Button btnChangePassword;
    public Button btnAbout;

    public void btnManagePriceOnAction(ActionEvent actionEvent) {
    }

    public void btnAddDiscountOnAction(ActionEvent actionEvent) {
    }

    public void btnManageFeildOnAction(ActionEvent actionEvent) throws IOException {
        pngContainer.getChildren().clear();
        AnchorPane manageFieldsForm = FXMLLoader.load(getClass().getResource("/view/ManageFeildForm.fxml"));
        pngContainer.getChildren().add(manageFieldsForm);
    }

    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
    }

    public void btnAboutOnAction(ActionEvent actionEvent) {
    }
}
