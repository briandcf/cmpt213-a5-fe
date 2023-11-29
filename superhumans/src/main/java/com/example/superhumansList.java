package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class superhumansList {

    private static ArrayList<String> attrs;
    private static VBox listSupers;
    private static ArrayList<superhuman> list;

    public static VBox listSupers(ArrayList<superhuman> shList){
        listSupers = new VBox();
        list = shList;
         attrs = new ArrayList<>();
        attrs.addAll(Arrays.asList("ID", "Name", "Weight", "Height", "Type", "Strength"));

        listSupers.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        header.getChildren().addAll(geTitle(), getCheckboxes());
       
        listSupers.getChildren().addAll(header, getlist());
        return listSupers;
    }

    private static Label geTitle(){
        Label title = new Label("Superhumans List:");
        title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: Teal;");
        title.setPadding(new Insets(15));
        return title;
    }

    private static HBox getCheckboxes(){
        HBox box = new HBox();
        box.setSpacing(30);
        box.setPadding(new Insets(15));
        box.getChildren().addAll(getCheckbox("ID"),
                                 getCheckbox("Name"),
                                 getCheckbox("Weight"),
                                 getCheckbox("Height"),
                                 getCheckbox("Type"),
                                 getCheckbox("Strength")
                                 );



        return box;
    }

    private static CheckBox getCheckbox(String attribute){
        CheckBox checkBox = new CheckBox(attribute);
        checkBox.setPrefSize(120, 30);
        checkBox.setSelected(true);
        checkBox.setStyle("-fx-background-color: White; -fx-font-size: 16px;");
        checkBox.setOnAction((ActionEvent e) -> {
            if (checkBox.isSelected()) {
                attrs.add(checkBox.getText());
            } else {
                attrs.remove(checkBox.getText());
            }

            reorganizeAttr();

            listSupers.getChildren().set(1, getlist());


        });
        return checkBox;
    }
     private static void reorganizeAttr(){
        ArrayList<String> temp = new ArrayList<>();
        if(attrs.contains("ID")){
            temp.add("ID");
        }
        if(attrs.contains("Name")){
            temp.add("Name");
        }
        if(attrs.contains("Weight")){
            temp.add("Weight");
        }
        if(attrs.contains("Height")){
            temp.add("Height");
        }

        if(attrs.contains("Type")){
            temp.add("Type");
        }
        if(attrs.contains("Strength")){
            temp.add("Strength");
        }
        attrs = temp;
    }



    private static ScrollPane getlist(){
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
        box.setMinSize(730, 183);
        box.setStyle("-fx-border-width: 4; -fx-border-color: #3566ca;");


        VBox pictureBox = getAttributeHolder();
        pictureBox.setAlignment(Pos.CENTER);
        pictureBox.setMaxSize(182, 180);
        ImageView imageView = images.getCroppedLargestCircleImage(superH.getURL(), 81);
        pictureBox.getChildren().add(imageView);

        VBox firstBox = getAttributeHolder();
        VBox secondBox = getAttributeHolder();
        VBox thirdBox = getAttributeHolder();
        addApropriateAttributes(firstBox, secondBox, thirdBox, superH);

        box.getChildren().addAll(pictureBox, firstBox,secondBox,thirdBox);

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

    private static void addApropriateAttributes(VBox one, VBox two, VBox three, superhuman sh){
        VBox box;
        for(int i = 0; i < attrs.size(); i ++){
            if(i>3){
                box = three;
            }else if(i>1){
                box = two;
            }else
                box = one;
            
            if(attrs.get(i).equals("ID")){
                box.getChildren().add(getAttributeBox("ID", ("" + sh.getID())));
            }else if(attrs.get(i).equals("Name")){
                box.getChildren().add(getAttributeBox("Name", ("" + sh.getName())));
            }else if(attrs.get(i).equals("Weight")){
                box.getChildren().add(getAttributeBox("Weight", ("" + sh.getWeight())));
            }else if(attrs.get(i).equals("Height")){
                box.getChildren().add(getAttributeBox("Height", ("" + sh.getHeight())));
            }else if(attrs.get(i).equals("Type")){
                box.getChildren().add(getAttributeBox("Type", ("" + sh.getCategory())));
            }else if(attrs.get(i).equals("Strength")){
                box.getChildren().add(getAttributeBox("Strength", ("" + sh.getStrength())));
            }
            

        }

    }

    

}
