package com.example;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class dashboard {
    private static VBox dash = new VBox();

    public static VBox getDashboard(ArrayList<superhuman> list){
        
        dash.setAlignment(Pos.CENTER);
        
        HBox items = new HBox();
        items.setPadding(new Insets(30));
        items.setSpacing(50);
        items.setAlignment(Pos.CENTER);

        VBox buttons = new VBox();
        buttons.setSpacing(20);
        buttons.getChildren().addAll(
            dashboardButton("New Superhuman Found",1,list),
            dashboardButton("Vanished Superhuman",2,list),
            dashboardButton("Display All Superhumans",3, list),
            dashboardButton("Display Specific Superhuman",4,list)
        );



        items.getChildren().addAll(buttons, images.superhuman);

        dash.getChildren().addAll(getTitle(),items);
        dash.getChildren().add(superhumansList.listSupers(list));

        return dash;
    }

    private static Label getTitle(){
        Label title = new Label("Welcome Superhuman-Tracker!");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(30));
        return title;
    }

    private static Button dashboardButton(String label, int display,ArrayList<superhuman> list){
        Button button = new Button(label);
        button.setPrefWidth(250);
        button.setPrefHeight(50);
        button.setStyle("-fx-font-size: 16px;-fx-text-fill: #FFFFFF; -fx-background-color: #2E3C4E;");

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #34465E; -fx-font-size: 16px;-fx-text-fill: #FFFFFF; "));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #2E3C4E; -fx-font-size: 16px;-fx-text-fill: #FFFFFF;"));
        button.setOnMousePressed(e -> {button.setStyle("-fx-background-color: #2B3949; -fx-text-fill: #FFFFFF;");
                                       changeDisplay(display,list);});
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: #2E3C4E; -fx-font-size: 16px; -fx-text-fill: #FFFFFF;"));
        return button;
    }

    private static void changeDisplay(int display, ArrayList<superhuman> list){
        if(display == 1){

        }else if(display == 2){

        }else if(display == 3){
            dash.getChildren().set(2,superhumansList.listSupers(list));
        }else{
            dash.getChildren().set(2, specificSuperhuman.display(list));
        }
    }
}
