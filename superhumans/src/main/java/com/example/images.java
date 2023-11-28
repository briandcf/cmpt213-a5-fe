package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class images {

    public static ImageView superhuman = new ImageView(
        new Image("file:superhumans\\src\\main\\resources\\com\\example\\images\\superhuman.jpg"));

    static {
        superhuman.setClip(new Circle(130,130,130));
     }
    
    public static ImageView getCroppedLargestCircleImage(String url, double newLength){
        Image img = new Image(url);
        ImageView iView = new ImageView(img);

        int centerX = ((int)img.getWidth())/2;
        int centerY = ((int)img.getHeight())/2;

        int radius = (centerX > centerY ? centerY : centerX);

        if (centerX > centerY){
            iView.setClip(new Circle(centerX,centerY,radius));
        }else{
            iView.setClip(new Circle(centerX,centerY,radius));
        }

        double scale = newLength/radius;

        iView.scaleXProperty().set(scale);
        iView.scaleYProperty().set(scale);

        return iView;
    }

}
