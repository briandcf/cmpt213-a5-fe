package com.example;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class specificSuperhuman {
    private static VBox box;
    public static VBox display(ArrayList<superhuman> list){
        box = new VBox();
        box.setMinHeight(569);
        box.setMaxHeight(580);
        box.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        VBox searchBoxHolder = new VBox();
        searchBoxHolder.setMaxHeight(75);
        searchBoxHolder.setPadding(new Insets(25));
        searchBoxHolder.setAlignment(Pos.TOP_CENTER);
        searchBoxHolder.getChildren().add(getSearchBox(list));


        VBox superHumanHolder = getSuperHumanHolder(list.get(0));
        

        box.getChildren().addAll(searchBoxHolder,superHumanHolder);
        return box;
    }

    public static ComboBox<String> getSearchBox(ArrayList<superhuman> list){
        ComboBox<String> searchBox = new ComboBox<>();
        searchBox.setPromptText("Select Superhuman");
        searchBox.setPrefHeight(50);
        searchBox.setPrefWidth(350);
        searchBox.setVisibleRowCount(5);
        searchBox.setStyle("-fx-font-size: 18px;");


        for(superhuman sp: list){
            searchBox.getItems().add("ID: #" + sp.getID() + "    |    Name: " + sp.getName());
        }

        searchBox.setOnAction(event -> {
            int id = getIdNum(searchBox.getValue());
            superhuman sp = superhuman.getSuperAt(id, list);
            box.getChildren().set(1, getSuperHumanHolder(sp));

        });

        return searchBox;
    }

    public static int getIdNum(String value){
        int startIdx = value.indexOf("#");
        int endIdx = value.indexOf(" ", startIdx);
        String id = value.substring(startIdx+1, endIdx);
        return Integer.parseInt(id);
    }

    




    public static VBox getSuperHumanHolder(superhuman sp){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);

        HBox picAndAttr = new HBox();
        picAndAttr.setAlignment(Pos.CENTER);
        picAndAttr.setPadding(new Insets(20));
        picAndAttr.setMaxHeight(400);
        picAndAttr.getChildren().addAll(getPicture(sp),getAttr(sp));

        box.getChildren().addAll(getIdAndName(sp),picAndAttr);
        return box;
    }

    public static Label getIdAndName(superhuman sp){
        Label label = new Label("ID: #" + sp.getID() + "   Name: " + sp.getName());
        label.setStyle("-fx-font-size: 35px; -fx-text-fill: Teal;");
        return label;
    }

    public static VBox getPicture(superhuman sp){
        VBox picture = getInnerBox();
        picture.getChildren().add(images.getCroppedLargestCircleImage(sp.getURL(), 160));
        return picture;
    }

    public static VBox getInnerBox(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setMaxSize(360,360);
        box.setMinSize(360,360);
        return box;
    }

    public static VBox getAttr(superhuman sp){
        VBox attr = getInnerBox();
        attr.setSpacing(20);
        attr.getChildren().addAll(getAttributeLabel("Weight: " + sp.getWeight()),
                                  getAttributeLabel("Height: " + sp.getHeight()),
                                  getAttributeLabel("Type: " + sp.getCategory()),
                                  getAttributeLabel("Strength: " + sp.getStrength()));       

        return attr;
    }

    public static VBox getAttributeLabel(String attr){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setMinSize(250, 50);
        box.setMaxSize(250, 50);
        box.setStyle("-fx-border-width: 2; -fx-background-color: #2E3C4E;");

        Label label = new Label(attr);
        label.setStyle("-fx-font-size: 16px;-fx-text-fill: #FFFFFF;");

        box.getChildren().add(label);
        
        return box;
    }

    
}
