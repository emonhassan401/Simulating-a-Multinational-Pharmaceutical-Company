package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductCategoryFindController {

    @javafx.fxml.FXML
    private TableView<ProductCategoryFindClass> productableView;

    @javafx.fxml.FXML
    private ComboBox<String> filterpcatagortComboBox;

    @javafx.fxml.FXML
    private ComboBox<String> selectComboBoox;

    @javafx.fxml.FXML
    private TextArea ShowTextField;

    ArrayList<ProductCategoryFindClass> categoryFindClasses = new ArrayList<>();


    @javafx.fxml.FXML
    private TableColumn<ProductCategoryFindClass, LocalDate> catagoryCol1;

    @javafx.fxml.FXML
    private TableColumn<ProductCategoryFindClass, String> DateCol;

    @javafx.fxml.FXML
    private DatePicker dateDatePicker;

    @javafx.fxml.FXML
    public void initialize() {

        catagoryCol1.setCellValueFactory(new PropertyValueFactory<>("productCatagory"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        filterpcatagortComboBox.getItems().addAll(
                "Antibiotic",
                "Vitamins & Supplements",
                "Vaccines",
                "Laboratory & Diagnostic Kits",
                "Pain Killer"
        );

        selectComboBoox.getItems().addAll(
                "Antibiotic",
                "Vitamins & Supplements",
                "Vaccines",
                "Laboratory & Diagnostic Kits",
                "Pain Killer"
        );
    }

    @javafx.fxml.FXML
    public void availableOrNotButton(ActionEvent actionEvent) {
        String selectedCategory = filterpcatagortComboBox.getValue();

        if (selectedCategory == null || selectedCategory.isEmpty()) {
            ShowAlert("Please select a category to filter.");
            return;
        }

        StringBuilder results = new StringBuilder();
        boolean found = false;


        for (ProductCategoryFindClass item : productableView.getItems()) {
            if (item.getProductCatagory().equalsIgnoreCase(selectedCategory)) {
                results.append(item.toString()).append("\n");
                found = true;
            }
        }

        if (found) {
            ShowTextField.setText(results.toString());
        } else {
            ShowTextField.setText("No product found for category: " + selectedCategory);
        }
    }


    @javafx.fxml.FXML
    public void AddProductButton(ActionEvent actionEvent) {
        LocalDate selectedDate = dateDatePicker.getValue();
        String selectedCategory = selectComboBoox.getValue();

        if (selectedDate == null || selectedCategory == null || selectedCategory.isEmpty()) {
            ShowAlert("Please select both date and category.");
            return;
        }


        ProductCategoryFindClass dd = new ProductCategoryFindClass(selectedDate, selectedCategory);

        categoryFindClasses.add(dd);
        productableView.getItems().add(dd);
    }

    void ShowAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
              ddt(actionEvent,"financialDashboard.fxml") ;
    }
    private void ddt(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}




