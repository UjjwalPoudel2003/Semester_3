package com.example.finaltest;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateReport extends Application {
    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String DB_USER = "COMP228_F23_piy_24";
    private static final String DB_PASSWORD = "password";

    // TableView for displaying student data
    private TableView<Student> studentView;

    public void start(Stage primaryStage) {
        // Create the main layout using BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Initialize TableView and its columns
        studentView = new TableView<>();
        TableColumn<Student, Integer> studentIdColumn = new TableColumn<>("StudentID");
        TableColumn<Student, String> firstNameColumn = new TableColumn<>("FirstName");
        TableColumn<Student, String> lastNameColumn = new TableColumn<>("LastName");
        TableColumn<Student, String> addressColumn = new TableColumn<>("Address");
        TableColumn<Student, String> cityColumn = new TableColumn<>("City");
        TableColumn<Student, String> provinceColumn = new TableColumn<>("Province");
        TableColumn<Student, String> postalCodeColumn = new TableColumn<>("PostalCode");

        // Set up cell value factories for each column
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        // Add columns to the TableView
        studentView.getColumns().addAll(studentIdColumn, firstNameColumn, lastNameColumn,
                addressColumn, cityColumn, provinceColumn, postalCodeColumn);

        // ComboBox for selecting provinces
        ComboBox<String> provinceComboBox = new ComboBox<>();
        provinceComboBox.setPromptText("Select province");
        ObservableList<String> provinces = fetchDistinctProvinces();
        provinceComboBox.setItems(provinces);

        // Button to trigger the display of student reports
        Button displayReportsButton = new Button("Display Reports");
        displayReportsButton.setOnAction(e -> displayStudentReports(provinceComboBox.getValue()));

        // Create a grid pane for layout of controls
        GridPane bottomPane = new GridPane();
        bottomPane.setHgap(10);
        bottomPane.setVgap(10);
        // Add controls to the grid pane
        bottomPane.addRow(0, provinceComboBox, displayReportsButton);

        // Set layout components in the root BorderPane
        root.setBottom(bottomPane);
        root.setCenter(studentView);

        // Create and set up the Scene
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to fetch distinct provinces from the database
    private ObservableList<String> fetchDistinctProvinces() {
        ObservableList<String> provinces = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectQuery = "SELECT DISTINCT province FROM Students";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String province = resultSet.getString("province");
                    provinces.add(province);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return provinces;
    }

    // Method to display student reports based on the selected province
    private void displayStudentReports(String selectedProvince) {
        if (selectedProvince != null && !selectedProvince.isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String selectQuery = "SELECT studentID, firstName, lastName, address, city, province, postalCode " +
                        "FROM Students WHERE province=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setString(1, selectedProvince);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    ObservableList<Student> students = FXCollections.observableArrayList();

                    while (resultSet.next()) {
                        int studentId = resultSet.getInt("studentID");
                        String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        String address = resultSet.getString("address");
                        String city = resultSet.getString("city");
                        String province = resultSet.getString("province");
                        String postalCode = resultSet.getString("postalCode");

                        students.add(new Student(studentId, firstName, lastName, address, city, province, postalCode));
                    }

                    // Set the retrieved data in the TableView
                    studentView.setItems(students);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Please select province to display reports.");
        }
    }

    // Student class for representing student data
    public static class Student {
        private final SimpleIntegerProperty studentId;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty address;
        private final SimpleStringProperty city;
        private final SimpleStringProperty province;
        private final SimpleStringProperty postalCode;

        public Student(int studentId, String firstName, String lastName, String address, String city, String province, String postalCode) {
            this.studentId = new SimpleIntegerProperty(studentId);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.address = new SimpleStringProperty(address);
            this.city = new SimpleStringProperty(city);
            this.province = new SimpleStringProperty(province);
            this.postalCode = new SimpleStringProperty(postalCode);
        }

        public int getStudentId() {
            return studentId.get();
        }

        public String getFirstName() {
            return firstName.get();
        }

        public String getLastName() {
            return lastName.get();
        }

        public String getAddress() {
            return address.get();
        }

        public String getCity() {
            return city.get();
        }

        public String getProvince() {
            return province.get();
        }

        public String getPostalCode() {
            return postalCode.get();
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}