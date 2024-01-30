package com.example.assignment_5;

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

import java.sql.*;

public class GenerateReport extends Application {
    private static final String DB_URL = "jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD";
    private static final String DB_USER = "COMP228_F23_piy_24";
    private static final String DB_PASSWORD = "password";

    private TableView<DataRow> dataTableView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        dataTableView = new TableView<>();

        TableColumn<DataRow, Integer> playerIdColumn = new TableColumn<>("Player ID");
        TableColumn<DataRow, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<DataRow, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<DataRow, Integer> playerGameIdColumn = new TableColumn<>("Player Game ID");
        TableColumn<DataRow, Integer> gameIdColumn = new TableColumn<>("Game ID");
        TableColumn<DataRow, String> playingDateColumn = new TableColumn<>("Playing Date");
        TableColumn<DataRow, Integer> scoreColumn = new TableColumn<>("Score");
        TableColumn<DataRow, String> gameTitleColumn = new TableColumn<>("Game Title");

        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        playerGameIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerGameId"));
        gameIdColumn.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        playingDateColumn.setCellValueFactory(new PropertyValueFactory<>("playingDate"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        gameTitleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));

        dataTableView.getColumns().addAll(playerIdColumn, firstNameColumn, lastNameColumn, playerGameIdColumn, gameIdColumn, playingDateColumn, scoreColumn, gameTitleColumn);

        ComboBox<Integer> playerIdComboBox = new ComboBox<>();
        playerIdComboBox.setPromptText("Select Player ID");
        ObservableList<Integer> playerIds = fetchDistinctPlayerIds();
        playerIdComboBox.setItems(playerIds);

        Button displayReportsButton = new Button("Display Reports");
        displayReportsButton.setOnAction(e -> displayPlayerReports(playerIdComboBox.getValue()));

        GridPane bottomPane = new GridPane();
        bottomPane.setHgap(10);
        bottomPane.setVgap(10);
        bottomPane.addRow(0, playerIdComboBox, displayReportsButton);

        root.setBottom(bottomPane);
        root.setCenter(dataTableView);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Integer> fetchDistinctPlayerIds() {
        ObservableList<Integer> playerIds = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectQuery = "SELECT DISTINCT player_id FROM player";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int playerId = resultSet.getInt("player_id");
                    playerIds.add(playerId);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return playerIds;
    }

    private void displayPlayerReports(int selectedPlayerId) {
        if (selectedPlayerId > 0) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String selectQuery = "SELECT p.player_id, p.first_name, p.last_name, "
                        + "pg.player_game_id, pg.game_id, pg.playing_date, pg.score, g.game_title "
                        + "FROM player p "
                        + "LEFT JOIN playerandgame pg ON p.player_id = pg.player_id "
                        + "LEFT JOIN game g ON pg.game_id = g.game_id "
                        + "WHERE p.player_id=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                    preparedStatement.setInt(1, selectedPlayerId);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    ObservableList<DataRow> dataRows = FXCollections.observableArrayList();

                    while (resultSet.next()) {
                        int playerId = resultSet.getInt("player_id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        int playerGameId = resultSet.getInt("player_game_id");
                        int gameId = resultSet.getInt("game_id");
                        String playingDate = resultSet.getString("playing_date");
                        int score = resultSet.getInt("score");
                        String gameTitle = resultSet.getString("game_title");

                        dataRows.add(new DataRow(playerId, firstName, lastName, playerGameId, gameId, playingDate, score, gameTitle));
                    }

                    dataTableView.setItems(dataRows);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Select a Player ID to display reports.");
        }
    }

    public static class DataRow {
        private final SimpleIntegerProperty playerId;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleIntegerProperty playerGameId;
        private final SimpleIntegerProperty gameId;
        private final SimpleStringProperty playingDate;
        private final SimpleIntegerProperty score;
        private final SimpleStringProperty gameTitle;

        public DataRow(int playerId, String firstName, String lastName, int playerGameId, int gameId, String playingDate, int score, String gameTitle) {
            this.playerId = new SimpleIntegerProperty(playerId);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.playerGameId = new SimpleIntegerProperty(playerGameId);
            this.gameId = new SimpleIntegerProperty(gameId);
            this.playingDate = new SimpleStringProperty(playingDate);
            this.score = new SimpleIntegerProperty(score);
            this.gameTitle = new SimpleStringProperty(gameTitle);
        }

        public int getPlayerId() {
            return playerId.get();
        }

        public String getFirstName() {
            return firstName.get();
        }

        public String getLastName() {
            return lastName.get();
        }

        public int getPlayerGameId() {
            return playerGameId.get();
        }

        public int getGameId() {
            return gameId.get();
        }

        public String getPlayingDate() {
            return playingDate.get();
        }

        public int getScore() {
            return score.get();
        }

        public String getGameTitle() {
            return gameTitle.get();
        }
    }
}