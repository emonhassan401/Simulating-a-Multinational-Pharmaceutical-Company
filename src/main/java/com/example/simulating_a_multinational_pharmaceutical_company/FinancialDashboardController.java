package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class FinancialDashboardController {

    @FXML
    private TextField revenueTextField;
    @FXML
    private TextField expenseTextField;
    @FXML
    private TextField profitTextField;
    @FXML
    private TextArea showDataTextArea;

    @FXML
    public void showDataButton(ActionEvent actionEvent) {
        try {
            // Save the data
            financialDashboardClass data = new financialDashboardClass(
                    expenseTextField.getText(),
                    revenueTextField.getText(),
                    profitTextField.getText()
            );

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financialData.bin", true))) {
                oos.writeObject(data);
            }

            // Load last saved data
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financialData.bin"))) {
                financialDashboardClass loadedData = (financialDashboardClass) ois.readObject();
                showDataTextArea.setText(loadedData.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            showDataTextArea.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML

    public void salesReportButton(ActionEvent actionEvent) throws IOException {
        switchToDashboardd(actionEvent, "Sales Report.fxml");
    }

    private void switchToDashboardd(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void colabWithOtherDeptButton(ActionEvent actionEvent) {}


    @FXML
    public void pCatagogyButton(ActionEvent actionEvent) throws IOException {
        switchToDashboard(actionEvent, " Product Category find .fxml");
    }

    private void switchToDashboard(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }






    @FXML
    public void AOEButton(ActionEvent actionEvent) {}

    @FXML
    public void salesBudgetButton(ActionEvent actionEvent) {}

    @FXML
    public void exportFinanReportButton(ActionEvent actionEvent) {}
}
