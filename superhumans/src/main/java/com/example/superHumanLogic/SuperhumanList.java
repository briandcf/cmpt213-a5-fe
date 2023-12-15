package com.example.superHumanLogic;
import java.util.ArrayList;
import com.example.Images;

/**
 * Handles superhuman arrayList logic
 */

public class SuperhumanList {
    ArrayList<Superhuman> superhumanList = new ArrayList<Superhuman>();

    public SuperhumanList(){
        superhumanList.add(new Superhuman("Superman", 200, 200, "Kryptonian", 100, "https://upload.wikimedia.org/wikipedia/en/3/35/Supermanflying.png"));
    }

    public void addSuperhuman(Superhuman superhuman) {
        superhumanList.add(superhuman);
    }

    public void removeSuperhuman(int id) {
        for (Superhuman superhuman : superhumanList) {
            if (superhuman.getId() == id) {
                superhumanList.remove(superhuman);
                break;
            }
        }
    }
    public Superhuman getFirstSuperhuman() {
        return new Superhuman("Default", 10, 10, "Default", 10, Images.getPFP());
    }

    public Superhuman getSuperhuman(int id) {
        for (Superhuman superhuman : superhumanList) {
            if (superhuman.getId() == id) {
                return superhuman;
            }
        }
        return null;
    }
    
    public Superhuman getSuperhuman(String name) {
        for (Superhuman superhuman : superhumanList) {
            if (superhuman.getName().equals(name)) {
                return superhuman;
            }
        }
        return null;
    }

    public ArrayList<Superhuman> getSuperhumanList() {
        return superhumanList;
    }
    
    
}
