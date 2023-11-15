package com.example.stud_info;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button example = new Button("OK");
        Scene scene = new Scene(example, 320, 240);
        stage.setTitle("Informator");
        stage.setScene(scene);
        stage.show();
    }
}