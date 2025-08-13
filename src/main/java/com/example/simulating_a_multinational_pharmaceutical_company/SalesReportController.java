package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SalesReportController
{
    public static String reportText = "";

    @javafx.fxml.FXML
    private TextField totalSaletextField;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextArea reportTextArea;
    @javafx.fxml.FXML
    private TextField productNameTextField;
    @javafx.fxml.FXML
    private TextField unitSoldTTextField;
    @javafx.fxml.FXML
    private ComboBox <String>prodductCatagoryComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> salesRegionComboBox;

    ArrayList <SalesReportClass> salesReportClasses = new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {
        prodductCatagoryComboBox.getItems().addAll("Antibiotic",
                "Vitamins & Supplements",
                "Vaccines",
                "Laboratory & Diagnostic Kits",
                "Pain Killer") ;
        salesRegionComboBox.getItems().addAll("East Region ",
                "West Region " ,
                "Central Region " ,
                "Metro Region  " ,
                "Rural Region ");
    }

    @javafx.fxml.FXML
    public void grnarateReport(ActionEvent actionEvent) {
        String report =
                "Sales Report Summary:\n" +
                        "----------------------\n" +
                        "Product Name: " + productNameTextField.getText() + "\n" +
                        "Date of Sale: " + dateDatePicker.getValue() + "\n" +
                        "Sales Region: " + salesRegionComboBox.getValue() + "\n" +
                        "Total Sales Amount: " + totalSaletextField.getText() + "\n" +
                        "Units Sold: " + unitSoldTTextField.getText() + "\n" +
                        "Product Category: " + prodductCatagoryComboBox.getValue() + "\n\n" +

                        "Report Explanation:\n" +
                        "This report shows the sales performance for the selected product, including the total sales revenue and the number of units sold. " +
                        "It helps analyze which regions are generating more sales and which product categories are performing well. " +
                        "Use this information to adjust marketing strategies and inventory management to improve overall sales.";

        reportTextArea.setText(report);


    }

    @FXML
    public void backBUtton(ActionEvent actionEvent) throws IOException {
        switchToDashboardd(actionEvent, "financialDashboard.fxml");

    }

    private void switchToDashboardd(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
