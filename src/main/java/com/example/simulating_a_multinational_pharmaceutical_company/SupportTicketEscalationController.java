package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class SupportTicketEscalationController
{
    @javafx.fxml.FXML
    private TextArea discriptionArea;
    @javafx.fxml.FXML
    private ComboBox StatusindecatorComboBox;

    private final String FILE_NAME = "customerSupportData.bin";

    @javafx.fxml.FXML
    public void initialize() {
        StatusindecatorComboBox.getItems().addAll("New", "Resolved", "InProgress");
    }

    @javafx.fxml.FXML
    public void SubmissionButton(ActionEvent actionEvent) {
        String status = StatusindecatorComboBox.getValue() != null ? StatusindecatorComboBox.getValue().toString() : "";

        if (status.isEmpty()) {
            discriptionArea.setText("Please select a status before submitting.");
            return;
        }

        try {

            ArrayList<CustomerSupportDashboardClass> tickets;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                tickets = (ArrayList<CustomerSupportDashboardClass>) ois.readObject();
            }


            StringBuilder sb = new StringBuilder();
            for (CustomerSupportDashboardClass ticket : tickets) {
                sb.append(ticket.getName())
                        .append(" | ")
                        .append(ticket.getDate())
                        .append(" | ")
                        .append(ticket.getPriority())
                        .append(" | Status: ")
                        .append(status)
                        .append("\n");
            }

            discriptionArea.setText(sb.toString());

        } catch (IOException | ClassNotFoundException e) {
            discriptionArea.setText("Error reading customer tickets: " + e.getMessage());
            e.printStackTrace();
        }
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


