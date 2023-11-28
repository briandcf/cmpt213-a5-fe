package com.example;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class superhumansList {
    public static VBox listSupers(ArrayList<superhuman> list){
        VBox listSupers = new VBox();
        listSupers.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        HBox spacer = new HBox();
        spacer.setPrefWidth(425);

        header.getChildren().addAll(geTitle(), spacer, getDropDownMenu());


        HBox bottomSpacer = new HBox();
        bottomSpacer.setMinHeight(25);
       
        listSupers.getChildren().addAll(header, getlist(list), bottomSpacer);
        return listSupers;
    }

    private static Label geTitle(){
        Label title = new Label("Superhumans List:");
        title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(15));
        return title;
    }

    private static ComboBox<String> getDropDownMenu(){
        ComboBox<String> dropDown = new ComboBox<>();
        dropDown.getItems().addAll("ID","Name","Weight","Height","Category","Strength");
        dropDown.setOnMouseEntered(e -> dropDown.show());
        dropDown.setOnMouseExited(e -> {
        if (!isMouseOverDropDown(dropDown, e)) {
            dropDown.hide();
        }
        });
        

        return dropDown;
    }

    private static boolean isMouseOverDropDown(Node node, MouseEvent event) {
        Bounds bounds = node.localToScreen(node.getBoundsInLocal());
        double mouseX = event.getScreenX();
        double mouseY = event.getScreenY();

        return bounds.contains(mouseX, mouseY);
    }

    private static ScrollPane getlist(ArrayList<superhuman>list){
        ScrollPane box = new ScrollPane();
        // box.setMinSize(750,270);
        // box.setMaxSize(750, 270);
        //box.setTranslateX(25);

        VBox content = new VBox();
        
        content.setPadding(new Insets(25));
        content.setSpacing(20);
        content.setStyle("-fx-background-color: #121212;");

        for(superhuman superh: list){
          content.getChildren().add(makeSuperHumanBox(superh));

        }

        box.setContent(content);
        return box;
    }

    private static HBox makeSuperHumanBox(superhuman superH){
        HBox box = new HBox();
        box.setMaxSize(732, 183);
        box.setMinSize(732, 183);
        box.setStyle("-fx-border-width: 2; -fx-border-color: red;");


        VBox pictureBox = new VBox();
        pictureBox.setMaxSize(182, 180);
        pictureBox.setMinSize(182, 180);
        pictureBox.setPadding(new Insets(10));
        pictureBox.setStyle("-fx-border-width: 2; -fx-border-color: green");
        Image img = new Image(superH.getURL(),
        162, 162, true, true);
        pictureBox.getChildren().add(new ImageView(img));

        VBox idAndName = new VBox();
        idAndName.setMaxSize(182, 180);
        idAndName.setMinSize(182, 180);
        idAndName.setStyle("-fx-border-width: 2; -fx-border-color: green");

        VBox weightAndHeight = new VBox();
        weightAndHeight.setMaxSize(182, 180);
        weightAndHeight.setMinSize(182, 180);
        weightAndHeight.setStyle("-fx-border-width: 2; -fx-border-color: green");

        VBox categoryAndStrength = new VBox();
        categoryAndStrength.setMaxSize(182, 180);
        categoryAndStrength.setMinSize(182, 180);
        categoryAndStrength.setStyle("-fx-border-width: 2; -fx-border-color: green");

        box.getChildren().addAll(pictureBox,idAndName,weightAndHeight,categoryAndStrength);

        return box;
    }

}
