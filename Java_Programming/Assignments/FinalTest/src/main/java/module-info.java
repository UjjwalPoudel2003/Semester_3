module com.example.finaltest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.finaltest to javafx.fxml;
    exports com.example.finaltest;
}