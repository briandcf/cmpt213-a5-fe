package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class images {

    public static ImageView superhuman = new ImageView(
        new Image("file:superhumans\\src\\main\\resources\\com\\example\\images\\superhuman.jpg"));

    static {
        superhuman.setClip(new Circle(130,130,130));
        System.out.println("Superhuman Image Width: " + superhuman.getImage().getWidth());
        System.out.println("Superhuman Image Height: " + superhuman.getImage().getHeight());
    }
    
}
