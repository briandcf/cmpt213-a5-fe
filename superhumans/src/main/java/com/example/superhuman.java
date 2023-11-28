package com.example;

import java.util.ArrayList;

public class superhuman {
    private static int idMaker;
    private int id;
    private String name;
    private double weight;
    private String height;
    private String category;
    private  int strength;
    private String pictureURL;

    ArrayList<superhuman> list = new ArrayList<>();
    

    public superhuman(String name, double weight, String height, String category, int strength, String pictureURL){
        id = ++idMaker;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.category = category;
        this.strength = strength;
        this.pictureURL = pictureURL;
    }
    public superhuman(){
        initializeList();
    }

    public String getURL(){return this.pictureURL;}
    
    public void initializeList(){
        list.add(new superhuman("Rudolph", 169, "5'6\"","Fire", 80, "https://cdn.pixabay.com/photo/2015/12/01/21/49/christmas-1072939_1280.jpg"));
        list.add(new superhuman("Rudolph", 169, "5'6\"","Fire", 80, "https://cdn.pixabay.com/photo/2015/12/01/21/49/christmas-1072939_1280.jpg"));
        list.add(new superhuman("Rudolph", 169, "5'6\"","Fire", 80, "https://cdn.pixabay.com/photo/2015/12/01/21/49/christmas-1072939_1280.jpg"));
        list.add(new superhuman("Rudolph", 169, "5'6\"","Fire", 80, "https://cdn.pixabay.com/photo/2015/12/01/21/49/christmas-1072939_1280.jpg"));
        list.add(new superhuman("Rudolph", 169, "5'6\"","Fire", 80, "https://cdn.pixabay.com/photo/2015/12/01/21/49/christmas-1072939_1280.jpg"));
    }


}
