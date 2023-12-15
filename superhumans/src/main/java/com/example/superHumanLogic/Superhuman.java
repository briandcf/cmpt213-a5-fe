package com.example.superHumanLogic;

/**
 * Handles superhuman logic
 */

public class Superhuman {
    private static int idMaker;
    private int id;
    private String name;
    private int weight;
    private int height;
    private String type;
    private int strength;
    private String pictureURL;

    public Superhuman(String name, int weight, int height, String type, int strength, String pictureURL) {
        this.id = idMaker++;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.type = type;
        this.strength = strength;
        this.pictureURL = pictureURL;
    }
    public Superhuman() {
        this.id = idMaker++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }   

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        if(weight > 0){
            this.weight = weight;
        }
    }

    public void setHeight(int height) {
        if(height > 0){
            this.height = height;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStrength(int strength) {
        if(strength <= 0){
            this.strength = 1;
        }else if(strength > 100){
            this.strength = 100;
        }else 
            this.strength = strength;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }


}
