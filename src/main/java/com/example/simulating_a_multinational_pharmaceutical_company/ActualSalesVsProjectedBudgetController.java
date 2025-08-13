package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ActualSalesVsProjectedBudgetController
{
    @javafx.fxml.FXML
    private TableColumn <ActualSalesVsProjectedBudgeClass,String > bCol;
    @javafx.fxml.FXML
    private TextField totalbudgetTextField;
    @javafx.fxml.FXML
    private TextField totalSalesTextField;
    @javafx.fxml.FXML
    private ComboBox  <String>QuertercomboBox;
    @javafx.fxml.FXML
    private ComboBox <String>filterQuertercomboBox;
    @javafx.fxml.FXML
    private TableView <ActualSalesVsProjectedBudgeClass>tableView;
    @javafx.fxml.FXML
    private TextArea showTextArea;
    @javafx.fxml.FXML
    private TableColumn <ActualSalesVsProjectedBudgeClass ,String>qCol;
    @javafx.fxml.FXML
    private TableColumn <ActualSalesVsProjectedBudgeClass,String > sQol;

    ArrayList< ActualSalesVsProjectedBudgeClass> actualSalesVsProjectedBudgeClasses = new ArrayList<>() ;
    String fileName = "sales_budget.bin";

    @javafx.fxml.FXML
    public void initialize() {
        bCol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        sQol.setCellValueFactory(new PropertyValueFactory<>("sale"));
        qCol.setCellValueFactory(new PropertyValueFactory<>("querter"));

        QuertercomboBox.getItems().addAll("Q1" ,"Q2","Q3");
        filterQuertercomboBox.getItems().addAll("Q1" ,"Q2","Q3");
    }

    @javafx.fxml.FXML
    public void addtolistButton(ActionEvent actionEvent) {
        ActualSalesVsProjectedBudgeClass aa = new ActualSalesVsProjectedBudgeClass(
                QuertercomboBox.getValue(),
                totalbudgetTextField.getText(),
                totalSalesTextField.getText()
        );

        actualSalesVsProjectedBudgeClasses.add(aa);
        tableView.getItems().clear();
        tableView.getItems().addAll(actualSalesVsProjectedBudgeClasses);


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(actualSalesVsProjectedBudgeClasses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void genarateReportButton(ActionEvent actionEvent) {
        String selectedQuarter = filterQuertercomboBox.getValue();
        if (selectedQuarter == null) {
            showTextArea.setText("Please select a quarter to filter.");
            return;
        }

        // read from bin file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<ActualSalesVsProjectedBudgeClass> listFromFile =
                    (ArrayList<ActualSalesVsProjectedBudgeClass>) ois.readObject();

            StringBuilder report = new StringBuilder();
            for (ActualSalesVsProjectedBudgeClass item : listFromFile) {
                if (item.getQuerter().equals(selectedQuarter)) {
                    report.append("Quarter: ").append(item.getQuerter())
                            .append("\nBudget: ").append(item.getBudget())
                            .append("\nSales: ").append(item.getSale())
                            .append("\n----------------------\n");
                }
            }

            if (report.length() == 0) {
                showTextArea.setText("No data found for " + selectedQuarter);
            } else {
                showTextArea.setText(report.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showTextArea.setText("Error reading data file.");
        }
    }

    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
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

