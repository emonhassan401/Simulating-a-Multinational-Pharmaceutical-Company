module com.example.simulating_a_multinational_pharmaceutical_company {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simulating_a_multinational_pharmaceutical_company to javafx.fxml;
    exports com.example.simulating_a_multinational_pharmaceutical_company;
}