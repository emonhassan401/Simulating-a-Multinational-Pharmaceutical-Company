package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {

    public TextField nameTextField;
    public TextField passTextField;
    public ComboBox<String> roleCombobox;

    public void initialize() {
        roleCombobox.getItems().addAll("Admin", "User");
    }

    public void loginButton(ActionEvent event) {
        String username = nameTextField.getText().trim();
        String password = passTextField.getText().trim();
        String role = roleCombobox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            showAlert("Please fill all fields");
            return;
        }

        if ((username.equals("admin") && password.equals("123") && role.equals("Admin")) ||
                (username.equals("user") && password.equals("123") && role.equals("User"))) {
            switchToDashboard((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow());
        } else {
            showAlert("Invalid username, password, or role");
        }
    }

    private void switchToDashboard(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Main Dashboard");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error loading Main Dashboard");
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
