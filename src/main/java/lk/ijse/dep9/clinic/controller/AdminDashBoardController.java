package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashBoardController {
    public Button btnProfileManage;
    public Button btnViewRecods;
    public Button btnSetting;

    public void btnProfileManageOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/ProfileManageForm.fxml")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Open Source Medical Clinic");
        stage.show();
        stage.centerOnScreen();

        btnSetting.getScene().getWindow().hide();
    }

    public void btnViewRecodsOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Open Source Medical Clinic");
        stage.show();
        stage.centerOnScreen();

        btnSetting.getScene().getWindow().hide();
    }

    public void btnSettingOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/SettingForm.fxml")));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Open Source Medical Clinic");
        stage.show();
        stage.centerOnScreen();

        btnSetting.getScene().getWindow().hide();
    }
}
