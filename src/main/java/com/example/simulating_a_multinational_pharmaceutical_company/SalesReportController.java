package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesReportController
{
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

}