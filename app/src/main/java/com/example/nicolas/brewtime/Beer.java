package com.example.nicolas.brewtime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by nicolas on 02/01/16.
 */
public class Beer implements Serializable{

    private String name;
    private String type;
    private String brassage;
    private String quantity;
    private String secondaire;
    private String garde;
    private String embouteillage;
    private String degustation;

    private ArrayList<Ingredient> ingredients;

    private Calendar calendarBrassage;

    public Beer(){
        this.ingredients = new ArrayList<Ingredient>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrassage() {
        return brassage;
    }

    public String getSecondaire() {
        return secondaire;
    }

    public String getGarde() {
        return garde;
    }

    public String getEmbouteillage() {
        return embouteillage;
    }

    public String getDegustation() {
        return degustation;
    }

    public String getQuantity() {
        return quantity;
    }

    public ArrayList<Ingredient> getMalts() {
        ArrayList<Ingredient> malts = new ArrayList<Ingredient>();

        for(Ingredient ing : ingredients){
            if(ing.getType() == "malts"){
                malts.add(ing);
            }
        }
        return malts;
    }

    public ArrayList<Ingredient> getHoublonsAmer() {
        ArrayList<Ingredient> houblonsAmer = new ArrayList<Ingredient>();

        for(Ingredient ing : ingredients){
            if(ing.getType() == "houblonAm"){
                houblonsAmer.add(ing);
            }
        }
        return houblonsAmer;
    }

    public ArrayList<Ingredient> getHoublonsArome(){
        ArrayList<Ingredient> houblonsArome = new ArrayList<Ingredient>();

        for(Ingredient ing : ingredients){
            if(ing.getType() == "houblonAr"){
                houblonsArome.add(ing);
            }
        }
        return houblonsArome;
    }

    public ArrayList<Ingredient> getEpices() {
        ArrayList<Ingredient> epices = new ArrayList<Ingredient>();

        for(Ingredient ing : ingredients){
            if(ing.getType() == "epice"){
                epices.add(ing);
            }
        }
        return epices;
    }

    public ArrayList<Ingredient> getLevures() {
        ArrayList<Ingredient> levures = new ArrayList<Ingredient>();

        for(Ingredient ing : ingredients){
            if(ing.getType() == "levure"){
                levures.add(ing);
            }
        }
        return levures;
    }


    public ArrayList<Ingredient> getIngredients() {return ingredients;}

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrassage(String brassage) {
        this.brassage = brassage;
    }

    public void setSecondaire(String secondaire) {
        this.secondaire = secondaire;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }

    public void setEmbouteillage(String embouteillage) {
        this.embouteillage = embouteillage;
    }

    public void setDegustation(String degustation) {
        this.degustation = degustation;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients){
        this.ingredients =ingredients;
    }

    public Calendar getCalendarBrassage() {
        return calendarBrassage;
    }

    public void setCalendarBrassage(Calendar calendarBrassage) {
        this.calendarBrassage = calendarBrassage;
    }
}
