package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public Button btnButton;

    public void btnButtonOnAction(ActionEvent actionEvent) throws ClassNotFoundException, IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Username cannot be empty!").show();
            txtUsername.requestFocus();
            txtUsername.selectAll();
            return;
        } else if (password.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Password cannot be empty!").show();
            txtPassword.requestFocus();
            txtPassword.selectAll();
            return;
        } else if (!username.matches("^[A-Za-z0-9]+$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid login credentials!").show();
            txtUsername.requestFocus();
            txtUsername.selectAll();
            return;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medical_clinic", "root", "Sanduni@1996")) {
            System.out.println(connection);
//            String sql = "SELECT role FROM User WHERE username='%s' AND password='%s'";
//            sql = String.format(sql, username, password);
//            Statement st1 = connection.createStatement();
//            ResultSet resultSet = st1.executeQuery(sql);

            String sql = "SELECT role FROM User WHERE username=? AND password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,username);
            stm.setString(2, password);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                Scene scene = null;
                switch (role) {
                    case "Admin":
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/AdminDashBoard.fxml")));
                        break;
                    case "Doctor":
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/DoctorDashboard.fxml")));
                        break;
                    default:
                        scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/ReceptionistDashboard.fxml")));
                }
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Open Source Medical Clinic");
                stage.show();
                stage.centerOnScreen();

                txtPassword.getScene().getWindow().hide();
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid login credentials!").show();
                txtUsername.requestFocus();
                txtPassword.requestFocus();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "fail to connect with the database!").show();
        }


    }
}