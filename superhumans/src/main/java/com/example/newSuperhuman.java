package com.example;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class newSuperhuman {
    public static VBox add(ArrayList<superhuman> list){
        VBox box = new VBox();
        box.setMinHeight(569);
        box.setMaxHeight(580);
        box.setStyle("-fx-border-width: 2; -fx-border-color: teal;");



        box.getChildren().addAll(geTitle(), getBody());

        return box;
    }

    private static Label geTitle(){
        Label title = new Label("Add Superhuman:");
        title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(15));
        return title;
    }

    private static HBox getBody(){
        HBox body = new HBox();
        body.setAlignment(Pos.CENTER);
        body.setSpacing(50);
        body.setTranslateY(-15);

        body.getChildren().addAll(getLeftSide(), getRightSide());

        return body;
    }

    private static VBox getLeftSide(){
        VBox vbox = new VBox();
        vbox.setMinSize(494,494);

        vbox.getChildren().addAll(getLabelAndText("Name: ", "Name"),
                                  getLabelAndText("Weight: ", "XXX lbs"),
                                  getLabelAndText("Height: ", "X'XX\""),
                                  getLabelAndText("Type: ", "Type"),
                                  getLabelAndText("Strength: ", "1 < X > 100"),
                                  getLabelAndText("URL", "URL"));

        return vbox;
    }

    private static HBox getLabelAndText(String attribute, String prompt){
        HBox box = new HBox();
        box.setPadding(new Insets(30));
        box.setSpacing(25);
        box.setMinSize(494,50);
        box.getChildren().addAll(getLabel(attribute), getTextBox(prompt));

        return box;
    }

    private static Label getLabel(String attribute){
        Label label = new Label(attribute);
        label.setMinSize(150, 50);
        label.setStyle("-fx-font-size: 25px; -fx-text-fill: White;");

        return label;
    }

    private static TextField getTextBox(String prompt){
        TextField box = new TextField();
        box.setMinSize(250, 30);
        box.setTranslateY(10);
        box.setEditable(false);
        

        return box;
    }

    private static VBox getRightSide(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setMinSize(494,494);
        box.getChildren().add(images.defaultPFP);
        return box;
    }

}
