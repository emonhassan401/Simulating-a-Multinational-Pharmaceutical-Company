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

import java.io.*;
import java.util.ArrayList;

public class NewCustomerQueryController
{
    @javafx.fxml.FXML
    private ComboBox inquiryComboBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private TextField numberTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextArea addressTextArea;
    @javafx.fxml.FXML
    private ComboBox customerTypeComboBox;
    @javafx.fxml.FXML
    private TextArea showtextarea;

    private final String FILE_NAME = "newCustomer.bin";

    @javafx.fxml.FXML
    public void initialize() {
        inquiryComboBox.getItems().addAll("Complaint", "Info", "Feedback");
        customerTypeComboBox.getItems().addAll("New", "Returning", "VIP");
    }

    @javafx.fxml.FXML
    public void addTobinButton(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String phone = numberTextField.getText();
        String email = emailTextField.getText();
        String customerType = customerTypeComboBox.getValue() != null ? customerTypeComboBox.getValue().toString() : "";
        String inquiry = inquiryComboBox.getValue() != null ? inquiryComboBox.getValue().toString() : "";
        String address = addressTextArea.getText();


        if(name.isEmpty() || phone.isEmpty() || email.isEmpty() || customerType.isEmpty() || inquiry.isEmpty()) {
            showtextarea.setText("Please fill all fields and select options!");
            return;
        }

        NewCustomerQueryClass customer = new NewCustomerQueryClass(name, phone, email, customerType, inquiry);

        ArrayList<NewCustomerQueryClass> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (ArrayList<NewCustomerQueryClass>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File does not exist yet, it's fine
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        list.add(customer);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder sb = new StringBuilder();
        for (NewCustomerQueryClass c : list) {
            sb.append(c.toString()).append("\n");
        }
        showtextarea.setText(sb.toString());


        nameTextField.clear();
        numberTextField.clear();
        emailTextField.clear();
        addressTextArea.clear();
        inquiryComboBox.getSelectionModel().clearSelection();
        customerTypeComboBox.getSelectionModel().clearSelection();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
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
