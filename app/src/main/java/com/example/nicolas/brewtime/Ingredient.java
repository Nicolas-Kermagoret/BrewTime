package com.example.nicolas.brewtime;

import java.io.Serializable;

/**
 * Created by nicolas on 06/10/16.
 */

public class Ingredient implements Serializable {

    private String name;
    private String type;
    private int quantity;

    public Ingredient(String name, String type, int quantity){
        this.name = name;
        this.type= type;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
