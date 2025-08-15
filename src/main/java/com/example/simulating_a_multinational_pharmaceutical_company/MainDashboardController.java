package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void CSDbutton(ActionEvent actionEvent) throws IOException {
        switchToDashboard(actionEvent, "Customer Support Dashboard.fxml");
    }

    @javafx.fxml.FXML
    public void finacedeptButton(ActionEvent actionEvent) throws IOException {
        switchToDashboard(actionEvent, "financialDashboard.fxml");
    }

    private void switchToDashboard(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
