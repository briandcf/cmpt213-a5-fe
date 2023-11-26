package com.example;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class superhumansList {
    public static VBox listSupers(){
        VBox listSupers = new VBox();
        listSupers.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        HBox spacer = new HBox();
        spacer.setPrefWidth(425);

        header.getChildren().addAll(geTitle(), spacer, getDropDownMenu());

        
       
        listSupers.getChildren().addAll(header, getlist());
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

    private static ScrollPane getlist(){
        ScrollPane list = new ScrollPane();


        return list;
    }

}
