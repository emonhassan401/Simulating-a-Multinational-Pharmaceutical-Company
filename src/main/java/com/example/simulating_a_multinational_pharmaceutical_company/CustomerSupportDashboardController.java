package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class CustomerSupportDashboardController
{
    @javafx.fxml.FXML
    private ComboBox priorityComboBox;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextArea showTextArea;

    private final String FILE_NAME = "customerSupportData.bin";
    private ArrayList<CustomerSupportDashboardClass> tickets = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        priorityComboBox.getItems().addAll("High", "Medium", "Low");


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tickets = (ArrayList<CustomerSupportDashboardClass>) ois.readObject();
            refreshTextArea();
        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        String name = customerNameTextField.getText();
        String date = dateDatePicker.getValue() != null ? dateDatePicker.getValue().toString() : "";
        String priority = priorityComboBox.getValue() != null ? priorityComboBox.getValue().toString() : "";

        if (name.isEmpty() || date.isEmpty() || priority.isEmpty()) {
            showTextArea.setText("Please fill all fields before adding.");
            return;
        }

        CustomerSupportDashboardClass ticket = new CustomerSupportDashboardClass(name, date, priority);
        tickets.add(ticket);


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tickets);
        } catch (IOException e) {
            showTextArea.setText("Error saving data: " + e.getMessage());
            return;
        }

        refreshTextArea();


        customerNameTextField.clear();
        dateDatePicker.setValue(null);
        priorityComboBox.setValue(null);
    }

    private void refreshTextArea() {
        StringBuilder sb = new StringBuilder();
        for (CustomerSupportDashboardClass ticket : tickets) {
            sb.append(ticket.toString()).append("\n");
        }
        showTextArea.setText(sb.toString());
    }

    @javafx.fxml.FXML
    public void supportTicketForEscalationButton(ActionEvent actionEvent) throws IOException {
        ddt(actionEvent,"Support Ticket Escalation.fxml");
    }

    private void ddt(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void checkTicketStatusButton(ActionEvent actionEvent) throws IOException {

        AA (actionEvent,"Ticket Status Dashboard.fxml") ;
    }


    private void AA(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }









    @javafx.fxml.FXML
    public void faqButton(ActionEvent actionEvent) {}

    @javafx.fxml.FXML
    public void maintainCustomerfeedbackButton(ActionEvent actionEvent) throws IOException{
        ss(actionEvent,"Customer Feedback Reports.fxml") ;
    }

    private void ss(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void newCustomerQueryButton(ActionEvent actionEvent) throws IOException {

        pr(actionEvent,"New Customer Query.fxml");
    }

    private void pr(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
