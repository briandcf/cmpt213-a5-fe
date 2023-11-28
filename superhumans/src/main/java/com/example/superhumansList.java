package com.example;

import java.util.ArrayList;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
        spacer.setPrefWidth(900);

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
        box.setMinSize(732, 183);
        box.setStyle("-fx-border-width: 4; -fx-border-color: #3566ca;");


        VBox pictureBox = getAttributeHolder();
        pictureBox.setAlignment(Pos.CENTER);
        pictureBox.setMaxSize(182, 180);
        ImageView imageView = images.getCroppedLargestCircleImage(superH.getURL(), 81);
        pictureBox.getChildren().add(imageView);

        VBox idAndName = getAttributeHolder();
        idAndName.getChildren().add(getAttributeBox("ID", ("" + superH.getID())));
        idAndName.getChildren().add(getAttributeBox("Name", ("" + superH.getName())));

        VBox weightAndHeight = getAttributeHolder();
        weightAndHeight.getChildren().add(getAttributeBox("Weight", ("" + superH.getWeight())));
        weightAndHeight.getChildren().add(getAttributeBox("Height", ("" + superH.getHeight())));

        VBox categoryAndStrength = getAttributeHolder();
        categoryAndStrength.getChildren().add(getAttributeBox("Type", ("" + superH.getCategory())));
        categoryAndStrength.getChildren().add(getAttributeBox("Strength", ("" + superH.getStrength())));

        box.getChildren().addAll(pictureBox,idAndName,weightAndHeight,categoryAndStrength);

        return box;
    }

    private static VBox getAttributeHolder(){
        VBox box = new VBox();
        box.setMinHeight(180);
        box.setMaxHeight(180);
        box.setMinWidth(300);
        box.setPadding(new Insets(32));
        box.setSpacing(33);
        box.setStyle("-fx-border-width: 2; -fx-border-color: #3566ca");
        return box;
    }

    private static VBox getAttributeBox(String attribute, String value){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        Label label = new Label(attribute + ": " + value);
        label.setStyle("-fx-font-size:26px; -fx-font-weight: bold; -fx-text-fill: Teal;");

        box.getChildren().add(label);
        return box;
    }

    

}
