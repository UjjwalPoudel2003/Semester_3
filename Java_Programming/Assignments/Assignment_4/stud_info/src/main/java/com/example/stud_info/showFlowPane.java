package com.example.stud_info;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class showFlowPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(12, 12, 12, 12));
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(new Label("First Name: "), new TextField(), new Label("MI: "));
        TextField tf = new TextField();
        flowPane.getChildren().addAll(tf, new Label("Last Name"), new TextField());

        // Adding a new button
        Button addBtn = new Button("Add");
        flowPane.getChildren().add(addBtn);

        Scene newScene = new Scene(flowPane, 400, 500);
        stage.setTitle("Information Loader");
        stage.setScene(newScene);
        stage.show();
    }
}
