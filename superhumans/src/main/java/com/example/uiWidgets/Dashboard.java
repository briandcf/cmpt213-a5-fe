package com.example.uiWidgets;

import com.example.Images;
import com.example.superHumanLogic.SuperhumanList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Shows the main screen of the application, and is in charge of changing the bottom display 
 */

public class Dashboard {
    private static VBox dash = new VBox();
    private static SuperhumanList list;

    public static VBox getDashboard(SuperhumanList supers){
        list = supers;
        dash.setAlignment(Pos.CENTER);
        
        HBox items = new HBox();
        items.setPadding(new Insets(30));
        items.setSpacing(50);
        items.setAlignment(Pos.CENTER);

        VBox buttons = new VBox();
        buttons.setSpacing(20);
        buttons.getChildren().addAll(
            dashboardButton("New Superhuman Found",1),
            dashboardButton("Vanished Superhuman",2),
            dashboardButton("Display All Superhumans",3),
            dashboardButton("Display Specific Superhuman",4)
        );

        items.getChildren().addAll(buttons, Images.superhuman);

        dash.getChildren().addAll(getTitle(),items,ShowSuperhumanList.listSupers(list));
        return dash;
    }

    private static Label getTitle(){
        Label title = new Label("Welcome Superhuman-Tracker!");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(30));
        return title;
    }

    private static Button dashboardButton(String label, int display){
        Button button = new Button(label);
        button.setPrefWidth(250);
        button.setPrefHeight(50);
        button.setStyle("-fx-font-size: 16px;-fx-text-fill: #FFFFFF; -fx-background-color: #2E3C4E;");

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #34465E; -fx-font-size: 16px;-fx-text-fill: #FFFFFF; "));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #2E3C4E; -fx-font-size: 16px;-fx-text-fill: #FFFFFF;"));
        button.setOnMousePressed(e -> {button.setStyle("-fx-background-color: #2B3949; -fx-text-fill: #FFFFFF;");
                                       changeDisplay(display);});
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: #2E3C4E; -fx-font-size: 16px; -fx-text-fill: #FFFFFF;"));
        return button;
    }

    private static void changeDisplay(int display){
        if(display == 1){
            dash.getChildren().set(2, NewSuperhuman.add(list));
        }else if(display == 2){
            dash.getChildren().set(2, DeleteSuperhuman.DeleteSuper(list));
        }else if(display == 3){
            dash.getChildren().set(2, ShowSuperhumanList.listSupers(list));
        }else{
            dash.getChildren().set(2, SpecificSuperhuman.display(list));
        }
    }

    public static void updateDashboard(SuperhumanList ls){
        list = ls;
        dash.getChildren().set(2, ShowSuperhumanList.listSupers(list));
    }
}
