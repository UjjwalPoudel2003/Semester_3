package com.example.ujjwalpoudel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Ujjwal Poudel | 301284284

public class Main extends Application {

    // Main method
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // setting the background
        Background grayBackground = new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY));
        primaryStage.setTitle("Infro-stro");

        // Root for all the left and center panes
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Initializing the left pane
        GridPane leftPane = new GridPane();
        leftPane.setVgap(10);

        // Labels and text field for name address , city, province, postal code, phone number, email
        Label nameLabel = new Label("Full Name:");
        TextField nameField = new TextField();

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();

        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();

        Label provinceLabel = new Label("Province:");
        TextField provinceField = new TextField();

        Label postalCodeLabel = new Label("Postal Code:");
        TextField postalCodeField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        // arranging the labels and text fields in column
        leftPane.addColumn(0, nameLabel, addressLabel, cityLabel, provinceLabel, postalCodeLabel, phoneLabel, emailLabel);
        leftPane.addColumn(1, nameField, addressField, cityField, provinceField, postalCodeField, phoneField, emailField);

        // Setting the background of the left pane
        leftPane.setBackground(grayBackground);

        // Initilizing the center pane
        GridPane centerPane = new GridPane();
        centerPane.setPadding(new Insets(10, 0, 0, 100));
        centerPane.setHgap(20);

        // Creating check box for student council and volunteer work
        CheckBox studentCouncilCheckbox = new CheckBox("Student Council");
        CheckBox volunteerWorkCheckbox = new CheckBox("Volunteer Work");

        // Creating space for checkbox
        Label space = new Label();

        // Adding the checkbox in the center pane
        centerPane.add(studentCouncilCheckbox, 0, 0);

        // Adding the space here
        centerPane.add(space, 0, 1);

        // Adding another checkbox in the center pane
        centerPane.add(volunteerWorkCheckbox, 0, 2);
        centerPane.setBackground(grayBackground);

        // Creating the right pane
        GridPane rightPane = new GridPane();
        rightPane.setPadding(new Insets(10, 10, 0, 0));
        rightPane.setHgap(10);

        // Creating radio buttons for computer science and business
        ToggleGroup majorGroup = new ToggleGroup();
        RadioButton csRadioButton = new RadioButton("Computer Science");
        csRadioButton.setToggleGroup(majorGroup);
        RadioButton businessRadioButton = new RadioButton("Business");
        businessRadioButton.setToggleGroup(majorGroup);

        // Combo box to select courses
        ComboBox<String> courseComboBox = new ComboBox<>();
        courseComboBox.setPromptText("Select Courses");
        courseComboBox.setDisable(true);

        // adding the event listener for the courseComboBox
        majorGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            // Condition when the radio button is selected for cs (computer science)
            if (csRadioButton.isSelected()) {
                courseComboBox.setItems(FXCollections.observableArrayList("Python", "C#", "Java"));
                courseComboBox.setDisable(false);

                // Condition when the radio button is selected for business
            } else if (businessRadioButton.isSelected()) {
                courseComboBox.setItems(FXCollections.observableArrayList("Marketing", "Finance", "Management"));
                courseComboBox.setDisable(false);

                // for default the combo box is disabled
            } else {
                courseComboBox.setDisable(true);
                courseComboBox.setValue(null);
            }
        });

        // creating a listview to store the selected course
        ListView<String> selectedCoursesListView = new ListView<>();
        selectedCoursesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !selectedCoursesListView.getItems().contains(selectedCourse)) {
                selectedCoursesListView.getItems().add(selectedCourse);
            }
        });


        root.setLeft(leftPane);
        root.setCenter(centerPane);
        root.setRight(rightPane);

        // Setting  display area for output
        VBox textAreaPane = new VBox(10);
        textAreaPane.setAlignment(Pos.CENTER);

        // Text Area for Selected Courses
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(200);
        textArea.setPrefHeight(150);
        rightPane.add(csRadioButton, 0, 0);
        rightPane.add(businessRadioButton, 1, 0);
        rightPane.add(courseComboBox, 0, 1, 2, 1);
        rightPane.add(selectedCoursesListView, 0, 2, 2, 1);
        rightPane.setBackground(grayBackground);


        // Display button
        Button submitButton = new Button("Display");
        submitButton.setOnAction(e -> {

            // On click displays the information
            StringBuilder info = new StringBuilder();
            info.append("Full Name: " + nameField.getText() + "\n");
            info.append("Address: " + addressField.getText() + "\n");
            info.append("City: " + cityField.getText() + "\n");
            info.append("Province: " + provinceField.getText() + "\n");
            info.append("Postal Code: " + postalCodeField.getText() + "\n");
            info.append("Phone Number: " + phoneField.getText() + "\n");
            info.append("Email: " + emailField.getText() + "\n");

            if (csRadioButton.isSelected()) {
                info.append("Major: Computer Science\n");
            } else if (businessRadioButton.isSelected()) {
                info.append("Major: Business\n");
            }

            ObservableList<String> selectedCourses = selectedCoursesListView.getItems();

            if (!selectedCourses.isEmpty()) {
                info.append("Selected Courses: " + String.join(", ", selectedCourses) + "\n");
            }

            info.append("Additional Information: ");
            if (studentCouncilCheckbox.isSelected()) {
                info.append("Student Council, ");
            }
            if (volunteerWorkCheckbox.isSelected()) {
                info.append("Volunteer Work, ");
            }

            textArea.setText(info.toString());
        });

        textAreaPane.getChildren().addAll(submitButton, textArea);
        root.setBottom(textAreaPane);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}