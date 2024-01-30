module com.example.assignment_5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.assignment_5 to javafx.fxml;
    exports com.example.assignment_5;
}