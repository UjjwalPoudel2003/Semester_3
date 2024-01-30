package com.example.assignment_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    private static final String DB_URL = "jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD";
    private static final String DB_USER = "COMP228_F23_piy_24";
    private static final String DB_PASSWORD = "password";

    private TextField playerIDField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField addressField = new TextField();
    private TextField postalCodeField = new TextField();
    private TextField provinceField = new TextField();
    private TextField phoneNumberField = new TextField();
    private TextField gameIdField = new TextField();
    private TextField gameTitleField = new TextField();
    private TextField playerIDField2 = new TextField();
    private TextField gameIdField2 = new TextField();
    private TextField playergameIDField = new TextField();
    private TextField playedDateField = new TextField();
    private TextField scoreField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java GUI APPLICATION");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        GridPane leftPane = new GridPane();
        leftPane.setVgap(10);
        Label idLabel = new Label("Player ID:");
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name");

        Label addressLabel = new Label("Address:");

        Label postalCodeLabel = new Label("Postal Code");

        Label provinceLabel = new Label("Province:");

        Label phoneNumberLabel = new Label("Phone Number:");
        Button insertPlayerButton = new Button("Insert");
        Button updatePlayerButton = new Button("Update");

        leftPane.addColumn(0, idLabel, firstNameLabel, lastNameLabel, addressLabel, postalCodeLabel, provinceLabel, phoneNumberLabel);
        leftPane.addColumn(1, playerIDField, firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField);
        leftPane.addRow(8, insertPlayerButton, updatePlayerButton);

        GridPane centerPane = new GridPane();
        centerPane.setPadding(new Insets(0, 0, 0, 30));
        centerPane.setHgap(20);
        centerPane.setVgap(10);
        Label gameIdLabel = new Label("Game ID:");
        Label gameTitleLabel = new Label("Game Title:");
        Button insertGameButton = new Button("Insert");
        Button updateGameButton = new Button("Update");
        GridPane.setMargin(gameTitleLabel, new Insets(0, 0, 0, 0));

        centerPane.addColumn(0, gameIdLabel, gameTitleLabel);
        centerPane.addColumn(1, gameIdField, gameTitleField);
        centerPane.addRow(4, insertGameButton, updateGameButton);

        GridPane rightPane = new GridPane();
        rightPane.setPadding(new Insets(0, 0, 0, 0));
        rightPane.setHgap(10);
        rightPane.setVgap(10);
        Label playerGameId = new Label("Player Game ID");
        Label game_id = new Label("Game ID");
        Label player_id = new Label("Player ID");
        Label playing_date = new Label("Playing Date");
        Label score = new Label("Score");
        Button insertPlayerGameButton = new Button("Insert");
        Button updatePlayerGameButton = new Button("Update");
        rightPane.addColumn(0, playerGameId, game_id, player_id, playing_date, score);
        rightPane.addColumn(1, playergameIDField, gameIdField2, playerIDField2, playedDateField, scoreField);
        rightPane.addRow(6, insertPlayerGameButton, updatePlayerGameButton);

        insertPlayerButton.setOnAction(e -> insertPlayerData());
        updatePlayerButton.setOnAction(e -> updatePlayerData());
        insertGameButton.setOnAction(e -> insertGameData());
        updateGameButton.setOnAction(e -> updateGameData());
        insertPlayerGameButton.setOnAction(e -> insertPlayerGameData());
        updatePlayerGameButton.setOnAction(e -> updatePlayerGameData());

        root.setLeft(leftPane);
        root.setCenter(centerPane);
        root.setRight(rightPane);
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void insertPlayerData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertPlayerQuery = "INSERT INTO player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertPlayerQuery)) {
                preparedStatement.setInt(1, Integer.parseInt(playerIDField.getText()));
                preparedStatement.setString(2, firstNameField.getText());
                preparedStatement.setString(3, lastNameField.getText());
                preparedStatement.setString(4, addressField.getText());
                preparedStatement.setString(5, postalCodeField.getText());
                preparedStatement.setString(6, provinceField.getText());
                preparedStatement.setString(7, phoneNumberField.getText());
                preparedStatement.executeUpdate();

                showAlert("Success", "Player Data inserted successfully!");

                System.out.println("Player Data inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertGameData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertGameQuery = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertGameQuery)) {
                preparedStatement.setInt(1, Integer.parseInt(gameIdField.getText()));
                preparedStatement.setString(2, gameTitleField.getText());
                preparedStatement.executeUpdate();
                showAlert("Success", "Game Data inserted successfully!");
                System.out.println("Game Data inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertPlayerGameData() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertPlayerGameQuery = "INSERT INTO playerandgame (player_game_id, game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertPlayerGameQuery)) {
                preparedStatement.setInt(1, Integer.parseInt(playergameIDField.getText()));
                preparedStatement.setInt(2, Integer.parseInt(gameIdField2.getText()));
                preparedStatement.setInt(3, Integer.parseInt(playerIDField2.getText()));
                preparedStatement.setString(4, playedDateField.getText());
                preparedStatement.setInt(5, Integer.parseInt(scoreField.getText()));

                preparedStatement.executeUpdate();

                showAlert("Success", "Player Game Data inserted successfully!");
                System.out.println("PlayerGame Data inserted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updatePlayerData() {
        if (!playerIDField.getText().isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String updateQuery = "UPDATE player SET first_name=?, last_name=?, address=?, postal_code=?, province=?, phone_number=? WHERE player_id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, firstNameField.getText());
                    preparedStatement.setString(2, lastNameField.getText());
                    preparedStatement.setString(3, addressField.getText());
                    preparedStatement.setString(4, postalCodeField.getText());
                    preparedStatement.setString(5, provinceField.getText());
                    preparedStatement.setString(6, phoneNumberField.getText());
                    preparedStatement.setInt(7, Integer.parseInt(playerIDField.getText()));
                    preparedStatement.executeUpdate();
                    showAlert("Success", "Update Player Data inserted successfully!");
                    System.out.println("Player information updated successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            showAlert("Error", "Please enter a Player ID to update.");
            System.out.println("Please enter a Player ID to update.");
        }
    }

    private void updateGameData() {
        if (!gameIdField.getText().isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String updateQuery = "UPDATE Game SET game_title=? WHERE game_id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, gameTitleField.getText());
                    preparedStatement.setInt(2, Integer.parseInt(gameIdField.getText()));
                    preparedStatement.executeUpdate();
                    showAlert("Success", "Update Game Data inserted successfully!");
                    System.out.println("Game information updated successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            showAlert("Error", "Please enter a Game ID to update.");
            System.out.println("Please enter a Game ID to update.");
        }
    }

    private void updatePlayerGameData() {
        if (!playergameIDField.getText().isEmpty()) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String updateQuery = "UPDATE playerandgame SET game_id=?, player_id=?, playing_date=?, score=? WHERE player_game_id=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setInt(1, Integer.parseInt(gameIdField2.getText()));
                    preparedStatement.setInt(2, Integer.parseInt(playerIDField2.getText()));
                    preparedStatement.setString(3, playedDateField.getText());
                    preparedStatement.setInt(4, Integer.parseInt(scoreField.getText()));
                    preparedStatement.setInt(5, Integer.parseInt(playergameIDField.getText()));
                    preparedStatement.executeUpdate();
                    showAlert("Success", "Update Player Game Data inserted successfully!");
                    System.out.println("PlayerGame information updated successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            showAlert("Error", "Please enter a Player Game ID to update.");
            System.out.println("Please enter a Player Game ID to update.");
        }
    }
}
