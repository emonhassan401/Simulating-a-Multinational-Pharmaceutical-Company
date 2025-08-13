package com.example.simulating_a_multinational_pharmaceutical_company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CollaborationWithOtherDepartmentsController
{
    @javafx.fxml.FXML
    private TextArea mszTextArea;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> queryComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> deptComBoBox;

    @javafx.fxml.FXML
    public void initialize() {
        // Populate departments
        deptComBoBox.getItems().addAll(
                "Research & Development",
                "Manufacturing",
                "Quality Control",
                "Regulatory Affairs",
                "Marketing & Sales",
                "Finance",
                "Logistics / Supply Chain"
        );

        // Populate query types
        queryComboBox.getItems().addAll(
                "Data Request",
                "Meeting Request",
                "Approval Needed",
                "Feedback",
                "Issue Report"
        );
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String dept = deptComBoBox.getValue();
        String query = queryComboBox.getValue();

        if (name == null || name.isEmpty() || dept == null || query == null) {
            mszTextArea.setText("Please fill in all fields before sending.");
            return;
        }

        String message = "Message from " + name + ":\n" +
                "Department: " + dept + "\n" +
                "Query Type: " + query + "\n\n" +
                "Your request has been sent successfully!";
        mszTextArea.setText(message);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        got(actionEvent, "financialDashboard.fxml");
    }

    private void got(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
