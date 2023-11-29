package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class images {

    private static String sp = "file:superhumans\\src\\main\\resources\\com\\example\\images\\superhuman.jpg";
    private static String pfp = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR31BbrGnfG0Ub7mK6fQBUHWqs9bhYyfwkfyg";

    public static ImageView superhuman = getCroppedLargestCircleImage(sp, 130);
    public static ImageView defaultPFP = getCroppedLargestCircleImage(pfp, 225);

    
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
