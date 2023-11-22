module com.example.ujjwalpoudel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ujjwalpoudel to javafx.fxml;
    exports com.example.ujjwalpoudel;
}