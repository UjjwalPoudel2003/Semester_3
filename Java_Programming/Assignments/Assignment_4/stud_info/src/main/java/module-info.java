module com.example.stud_info {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stud_info to javafx.fxml;
    exports com.example.stud_info;
}