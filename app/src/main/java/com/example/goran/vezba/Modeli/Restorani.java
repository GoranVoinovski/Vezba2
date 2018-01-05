package com.example.goran.vezba.Modeli;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by goran on 18.12.17.
 */

public class Restorani implements Serializable{
    String logo;
    String city;
    String name;
    String rating;
    public ArrayList<Menu> menu;

    public Restorani(String logo, String city, String name, String rating, ArrayList<Menu> menu) {
        this.logo = logo;
        this.city = city;
        this.name = name;
        this.rating = rating;
        this.menu = menu;

    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }
}
