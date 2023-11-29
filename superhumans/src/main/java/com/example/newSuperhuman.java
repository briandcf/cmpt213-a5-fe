package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class newSuperhuman {
    private static ArrayList<superhuman> list;
    private static HashMap<String, TextField> attrs;
    private static TextField[] texts;

    public static VBox add(ArrayList<superhuman> ls){
        list = ls;
        initializeMap();
        texts = new TextField[6];


        VBox box = new VBox();
        box.setMinHeight(569);
        box.setMaxHeight(580);
        box.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        HBox header = new HBox();
        HBox spacer = new HBox();
        spacer.setMinWidth(775);
        header.getChildren().addAll(geTitle(), spacer, getSubmit());

        box.getChildren().addAll(header, getBody());

        return box;
    }
    private static void initializeMap(){
        attrs = new HashMap<>();
        attrs.put("Name",getTextBox("Name"));
        attrs.put("Weight",getTextBox("lbs"));
        attrs.put("Height",getTextBox("cm"));
        attrs.put("Type",getTextBox("Type"));
        attrs.put("Strength",getTextBox("1 < X > 100"));
        attrs.put("URL",getTextBox("URL"));

    }

    private static Label geTitle(){
        Label title = new Label("Add Superhuman:");
        title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(15));
        title.setMinWidth(250);
        return title;
    }
    private static Button getSubmit(){
        Button submit = new Button("Submit");
        submit.setMinSize(250, 50);
        submit.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: orange;");

        submit.setOnAction(event -> {
            
            String name = attrs.get("Name").getText();
            String w = attrs.get("Weight").getText();
            int weight = Integer.parseInt(w);
            String h = attrs.get("Height").getText();
            int height = Integer.parseInt(h);
            String type = attrs.get("Type").getText();
            String s = attrs.get("Strength").getText();
            int strength = Integer.parseInt(s);
            String url = attrs.get("URL").getText();

            superhuman newSuperhuman = new superhuman(name, 56, 56, type, 99, url);

            list.add(newSuperhuman);
            resetTextFields();
        });
        
        return submit;
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

        vbox.getChildren().addAll(getLabelAndText("Name"),
                                  getLabelAndText("Weight"),
                                  getLabelAndText("Height"),
                                  getLabelAndText("Type"),
                                  getLabelAndText("Strength"),
                                  getLabelAndText("URL"));

        return vbox;
    }

    private static HBox getLabelAndText(String attribute){
        HBox box = new HBox();
        box.setPadding(new Insets(30));
        box.setSpacing(25);
        box.setMinSize(494,50);
        box.getChildren().addAll(getLabel(attribute), attrs.get(attribute));

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
        box.setMinSize(250, 50);
        box.setStyle("-fx-control-inner-background: darkblue; -fx-font-size: 25px;");
        return box;
    }


    private static void resetTextFields(){
        for(TextField tf: attrs.values()){
            tf.clear();
        }
    }

    private static VBox getRightSide(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setMinSize(494,494);
        box.getChildren().add(images.defaultPFP);
        return box;
    }

}
