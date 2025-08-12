package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController
{
    @javafx.fxml.FXML
    private TextField passTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleCombobox;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        roleCombobox.getItems().addAll("Admin", "User");
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {
        String username = nameTextField.getText().trim();
        String password = passTextField.getText().trim();
        String role = roleCombobox.getValue();

        // Validation
        if (username.isEmpty()) {
            ShowAlert("Please enter your Username");
            return;
        }
        if (password.isEmpty()) {
            ShowAlert("Please enter your Password");
            return;
        }
        if (role == null) {
            ShowAlert("Please select a Role");
            return;
        }

        // Example login check (Replace this with your real authentication logic)
        if (username.equals("admin") && password.equals("123") && role.equals("Admin")) {
            switchToDashboard(actionEvent);
        } else if (username.equals("user") && password.equals("123") && role.equals("User")) {
            switchToDashboard(actionEvent);
        } else {
            ShowAlert("Invalid username, password, or role");
        }
    }

    void ShowAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void switchToDashboard(ActionEvent event) throws IOException {

           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   Parent root = FXMLLoader.load(getClass().getResource("MainDashBoard.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
}
