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

import java.io.*;

public class LogInController
{
    @javafx.fxml.FXML
    private TextField passTextField;
    @javafx.fxml.FXML
    private ComboBox<String> roleCombobox;
    @javafx.fxml.FXML
    private TextField nameTextField;

    private final String FILE_NAME = "loginData.bin";

    @javafx.fxml.FXML
    public void initialize() {
        roleCombobox.getItems().addAll("Admin", "User");
        loadLoginData();
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) throws IOException {
        String username = nameTextField.getText().trim();
        String password = passTextField.getText().trim();
        String role = roleCombobox.getValue();

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

        if (username.equals("admin") && password.equals("123") && role.equals("Admin")) {
            saveLoginData(username, password, role);
            switchToDashboard(actionEvent);
        } else if (username.equals("user") && password.equals("123") && role.equals("User")) {
            saveLoginData(username, password, role);
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

    private void saveLoginData(String username, String password, String role) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeUTF(username);
            out.writeUTF(password);
            out.writeUTF(role);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLoginData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            nameTextField.setText(in.readUTF());
            passTextField.setText(in.readUTF());
            roleCombobox.setValue(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
