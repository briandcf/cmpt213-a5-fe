package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.JsonInteraction.FromServer;
import com.example.superHumanLogic.SuperhumanList;
import com.example.uiWidgets.Dashboard;

/**
 * JavaFX Application main class
 */
public class App extends Application {

    private static Scene scene;
    SuperhumanList list = FromServer.getSuperHumanList();

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #121212;");

        root.getChildren().add(Dashboard.getDashboard(list));

        

        scene = new Scene(root, 1270, 1000);
        stage.setScene(scene);
        stage.setTitle("Superhuman Tracker");
        stage.setResizable(false);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch();
    }

}