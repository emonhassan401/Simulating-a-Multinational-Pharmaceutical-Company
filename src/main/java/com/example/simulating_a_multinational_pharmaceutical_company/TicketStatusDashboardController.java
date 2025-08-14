package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TicketStatusDashboardController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ComboBox ticketStatusComboBox;
    @javafx.fxml.FXML
    private TextField IssueTittle;
    @javafx.fxml.FXML
    private TableColumn issueCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView tableview;

    private final String FILE_NAME = "supportTicketData.bin";

    @javafx.fxml.FXML
    public void initialize() {
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        ticketStatusComboBox.getItems().addAll("New", "Resolved", "InProgress");
    }

    @javafx.fxml.FXML
    public void checkButton(ActionEvent actionEvent) {

        String name = nameTextField.getText();
        String id = idTextField.getText();
        String issue = IssueTittle.getText();
        String status = ticketStatusComboBox.getValue() != null ? ticketStatusComboBox.getValue().toString() : "";


        if (name.isEmpty() || id.isEmpty() || issue.isEmpty() || status.isEmpty()) {
            return;
        }


        TicketStatusDashboardClass ticket = new TicketStatusDashboardClass(name, id, status, issue);


        tableview.getItems().add(ticket);


        nameTextField.clear();
        idTextField.clear();
        IssueTittle.clear();
        ticketStatusComboBox.getSelectionModel().clearSelection();
    }



    @FXML
    public void bButton(ActionEvent actionEvent) throws IOException{

        ncp(actionEvent,"Customer Support Dashboard.fxml");
    }

    private void ncp(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

