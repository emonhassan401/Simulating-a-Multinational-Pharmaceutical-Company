package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void CSDbutton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void finacedeptButton(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage() ;
        Parent root = FXMLLoader.load(getClass().getResource("financialDashboard.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}