package com.example.uiWidgets;

import com.example.JsonInteraction.FromServer;
import com.example.JsonInteraction.ToServer;
import com.example.superHumanLogic.SuperhumanList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *   Shows the widgetto delete a superhuman
 */

public class DeleteSuperhuman {

    private static ComboBox<String> searchBox;
    private static SuperhumanList list;

    public static VBox DeleteSuper(SuperhumanList ls){
        list = ls;
        VBox box = SpecificSuperhuman.display(list);
        Button delete = getDeleteButton();
        HBox header = (HBox) box.getChildren().get(0);
        searchBox = (ComboBox<String>) header.getChildren().get(0);
        header.getChildren().set(1,delete);

        return box;
    }

    private static Button getDeleteButton(){
        Button delete = new Button("Delete");
        delete.setMinSize(250, 50);
        delete.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: orange;");
        delete.setOnMousePressed(e -> delete.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: red;"));
        delete.setOnAction(event -> {
            delete.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: orange;");
            System.out.println("DELETING");
            String boxVal = searchBox.getValue();
            System.out.println(boxVal);
            boxVal = boxVal.substring(boxVal.indexOf("|"));
            System.out.println(boxVal);
            boxVal = boxVal.substring(boxVal.indexOf(":")+2);
            System.out.println(boxVal);
                ToServer.removeSuperhuman(boxVal);
                list = FromServer.getSuperHumanList();
                Dashboard.updateDashboard(list);
        });
        return delete;
    }
}
