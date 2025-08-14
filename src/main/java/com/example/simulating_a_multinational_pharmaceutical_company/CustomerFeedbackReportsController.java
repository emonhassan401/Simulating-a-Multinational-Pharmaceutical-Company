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
import java.util.ArrayList;

public class CustomerFeedbackReportsController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn <CustomerFeedbackReportsClass,String> feedbackCOl;
    @javafx.fxml.FXML
    private TableColumn<CustomerFeedbackReportsClass,String> cnameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView < CustomerFeedbackReportsClass>tableView;
    @javafx.fxml.FXML
    private TextArea describeissueTextArea;
    @javafx.fxml.FXML
    private ComboBox <String>feedbackStatusComboBox;

    ArrayList<CustomerFeedbackReportsClass>customerFeedbackReportsClassArrayList =new ArrayList<>() ;

    @javafx.fxml.FXML
    public void initialize() {

        cnameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        feedbackCOl.setCellValueFactory(new PropertyValueFactory<>("describeIssue"));

        feedbackStatusComboBox.getItems().addAll("3 Star" ,"4 star","5 star") ;

    }


    @javafx.fxml.FXML
    public void addTOlist(ActionEvent actionEvent) {

        CustomerFeedbackReportsClass cc = new CustomerFeedbackReportsClass (
                nameTextField.getText() ,
                idTextField.getText(),
                feedbackStatusComboBox.getValue() ,
                describeissueTextArea.getText()

        );

        tableView.getItems().clear();
        customerFeedbackReportsClassArrayList.add(cc) ;
        tableView.getItems().addAll(customerFeedbackReportsClassArrayList);


    }

    @javafx.fxml.FXML
    public void backButtion(ActionEvent actionEvent) throws IOException {
        ss(actionEvent,"Customer Support Dashboard.fxml") ;

    }

    private void ss(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    }

