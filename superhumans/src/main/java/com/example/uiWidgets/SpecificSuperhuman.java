package com.example.uiWidgets;

import com.example.Images;
import com.example.JsonInteraction.FromServer;
import com.example.JsonInteraction.ToServer;
import com.example.superHumanLogic.Superhuman;
import com.example.superHumanLogic.SuperhumanList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *   Shows the widget to show a specific superhuman and edit it
 */

public class SpecificSuperhuman {
    private static VBox box;
    private static ComboBox<String> searchBox;
    private static SuperhumanList list;
    private static TextField[] fields;
    public static VBox display(SuperhumanList ls){
        list = ls;
        fields = new TextField[6];
        box = new VBox();
        box.setMinHeight(569);
        box.setMaxHeight(580);

        box.setStyle("-fx-border-width: 2; -fx-border-color: teal;");

        HBox searchBoxHolder = new HBox();
        searchBoxHolder.setMaxHeight(75);
        searchBoxHolder.setPadding(new Insets(25));
        searchBoxHolder.setAlignment(Pos.TOP_CENTER);
        searchBox = getSearchBox();
        searchBoxHolder.getChildren().addAll(searchBox, getEditButton());


        VBox superHumanHolder = getSuperHumanHolder(list.getFirstSuperhuman());
        

        box.getChildren().addAll(searchBoxHolder,superHumanHolder);
        return box;
    }

    public static ComboBox<String> getSearchBox(){
        ComboBox<String> searchBox = new ComboBox<>();
        searchBox.setPromptText("NEED TO SELECT A SUPERHUMAN");
        searchBox.setPrefHeight(50);
        searchBox.setPrefWidth(350);
        searchBox.setVisibleRowCount(5);
        searchBox.setStyle("-fx-font-size: 18px;");


        for(Superhuman sp: list.getSuperhumanList()){
            searchBox.getItems().add("ID: #" + sp.getId() + "    |    Name: " + sp.getName());
        }

        searchBox.setOnAction(event -> {
            int id = getIdNum(searchBox.getValue());
            Superhuman sp = list.getSuperhuman(id); 
            box.getChildren().set(1, getSuperHumanHolder(sp));

        });

        return searchBox;
    }

    public static Button getEditButton(){
        Button edit = new Button("Edit");
        edit.setMinSize(250, 50);
        edit.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: Blue;");
        edit.setOnMousePressed(e -> edit.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: black;"));
        edit.setOnAction(event -> {
            edit.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: blue;");
            System.out.println("EDITING");
            String boxVal = searchBox.getValue();
            System.out.println(boxVal);
            boxVal = boxVal.substring(boxVal.indexOf("|"));
            System.out.println(boxVal);
            boxVal = boxVal.substring(boxVal.indexOf(":")+2);
            System.out.println(boxVal);
            Superhuman sp = list.getSuperhuman(boxVal);
            box.getChildren().clear();
            box.getChildren().add(NewSuperhuman.add(list)); //Changes bottom display to look like adding

            VBox topContainer = (VBox) box.getChildren().get(0);
            HBox body = (HBox) topContainer.getChildren().get(1);
            VBox leftSide = (VBox) body.getChildren().get(0);
            
            leftSide.getChildren().get(0); //gets all the HBoxes containing the TextFields

            TextField nameField = getTextField(leftSide,0);
            nameField.setText(sp.getName());
            fields[0] = nameField;
            TextField weightField = getTextField(leftSide,1);
            weightField.setText(""+sp.getWeight());
            fields[1] = weightField;
            TextField heightField = getTextField(leftSide,2);
            heightField.setText(""+sp.getHeight());
            fields[2] = heightField;
            TextField typeField = getTextField(leftSide,3);
            typeField.setText(sp.getType());
            fields[3] = typeField;
            TextField strengthField = getTextField(leftSide,4);
            strengthField.setText(""+sp.getStrength());
            fields[4] = strengthField;
            TextField urlField = getTextField(leftSide,5);
            urlField.setText(sp.getPictureURL());
            fields[5] = urlField;

            //set the picture to the right side
            VBox rightSide = (VBox) body.getChildren().get(1);
            rightSide.getChildren().set(0, Images.getCroppedLargestCircleImage(sp.getPictureURL(), 225));


            HBox header = (HBox) topContainer.getChildren().get(0);
            Button submit = (Button) header.getChildren().get(2);
            setSubmitAction(submit, sp);
        

        });

        return edit;
    }

    public static int getIdNum(String value){
        int startIdx = value.indexOf("#");
        int endIdx = value.indexOf(" ", startIdx);
        String id = value.substring(startIdx+1, endIdx);
        return Integer.parseInt(id);
    }

    public static VBox getSuperHumanHolder(Superhuman sp){
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

    public static Label getIdAndName(Superhuman sp){
        Label label = new Label("ID: #" + sp.getId() + "   Name: " + sp.getName());
        label.setStyle("-fx-font-size: 35px; -fx-text-fill: Teal;");
        return label;
    }

    public static VBox getPicture(Superhuman sp){
        VBox picture = getInnerBox();
        picture.getChildren().add(Images.getCroppedLargestCircleImage(sp.getPictureURL(), 160));
        return picture;
    }

    public static VBox getInnerBox(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setMaxSize(360,360);
        box.setMinSize(360,360);
        return box;
    }

    public static VBox getAttr(Superhuman sp){
        VBox attr = getInnerBox();
        attr.setSpacing(20);
        attr.getChildren().addAll(getAttributeLabel("Weight: " + sp.getWeight()),
                                  getAttributeLabel("Height: " + sp.getHeight()),
                                  getAttributeLabel("Type: " + sp.getType()),
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

    public static TextField getTextField(VBox parent, int idx){
        HBox cont = (HBox) parent.getChildren().get(idx);
        return (TextField) cont.getChildren().get(1);
    }
    
    public static void setSubmitAction(Button submit, Superhuman sp){
        submit.setOnAction(event -> {

            if(fields[0] != null && !fields[0].getText().equals("")){
                sp.setName(fields[0].getText());
            }
            if(fields[1] != null && !fields[1].getText().equals("")){
                try{
                sp.setWeight(Integer.parseInt(fields[1].getText()));
                }catch(NumberFormatException e){
                    System.out.println("Weight was not a number, value not changed");
                }
            }
            if(fields[2] != null && !fields[2].getText().equals("")){
                try{
                sp.setHeight(Integer.parseInt(fields[2].getText()));
                }catch(NumberFormatException e){
                    System.out.println("Height was not a number, value not changed");
                }
            }
            if(fields[3] != null && !fields[3].getText().equals("")){
                sp.setType(fields[3].getText());
            }
            if(fields[4] != null && !fields[4].getText().equals("")){
                try{
                sp.setStrength(Integer.parseInt(fields[4].getText()));
                }catch(NumberFormatException e){
                    System.out.println("Strength was not a number, value not changed");
                }
            }
            if(fields[5] != null && !fields[5].getText().equals("")){
                sp.setPictureURL(fields[5].getText());
            }

            ToServer.updateSuperHuman(sp);
            list = FromServer.getSuperHumanList();
            Dashboard.updateDashboard(list);
            
        });
    }
}