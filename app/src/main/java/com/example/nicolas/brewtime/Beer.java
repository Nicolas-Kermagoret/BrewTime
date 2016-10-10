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

    private ArrayList<String> malts;
    private ArrayList<String> houblonsAmer;
    private ArrayList<String> houblonsArome;
    private ArrayList<String> epices;
    private ArrayList<String> levures;

    private ArrayList<String> maltsQuantity;
    private ArrayList<String> houblonsAmerQuantity;
    private ArrayList<String> houblonsAromeQuantity;
    private ArrayList<String> epicesQuantity;
    private ArrayList<String> levuresQuantity;

    private Calendar calendarBrassage;

    public Beer(){
        this.malts = new ArrayList<String>();
        this.houblonsAmer = new ArrayList<String>();
        this.houblonsArome = new ArrayList<String>();
        this.epices = new ArrayList<String>();
        this.levures = new ArrayList<String>();

        this.maltsQuantity = new ArrayList<String>();
        this.houblonsAmerQuantity = new ArrayList<String>();
        this.houblonsAromeQuantity = new ArrayList<String>();
        this.epicesQuantity = new ArrayList<String>();
        this.levuresQuantity = new ArrayList<String>();

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

    public ArrayList<String> getMalts() {
        return malts;
    }

    public ArrayList<String> getHoublonsAmer() {
        return houblonsAmer;
    }

    public ArrayList<String> getHoublonsArome() {
        return houblonsArome;
    }

    public ArrayList<String> getEpices() {
        return epices;
    }

    public ArrayList<String> getLevures() {
        return levures;
    }

    public String getQuantity() {
        return quantity;
    }

    public ArrayList<String> getMaltsQuantity() {
        return maltsQuantity;
    }

    public ArrayList<String> getHoublonsAmerQuantity() {
        return houblonsAmerQuantity;
    }

    public ArrayList<String> getHoublonsAromeQuantity() {
        return houblonsAromeQuantity;
    }

    public ArrayList<String> getEpicesQuantity() {
        return epicesQuantity;
    }

    public ArrayList<String> getLevuresQuantity() {
        return levuresQuantity;
    }

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

    public void addMalt(Ingredient malt) {
        this.malts.add(malt.getName());
        this.maltsQuantity.add(String.valueOf(malt.getQuantity()));
    }

    public void addHoublonAmer(Ingredient amer) {
        this.houblonsAmer.add(amer.getName());
        this.houblonsAmerQuantity.add(String.valueOf(amer.getQuantity()));
    }

    public void addHoublonArome(Ingredient arome) {
        this.houblonsArome.add(arome.getName());
        this.houblonsAromeQuantity.add(String.valueOf(arome.getQuantity()));
    }

    public void addEpice(Ingredient epice) {
        this.epices.add(epice.getName());
        this.epicesQuantity.add(String.valueOf(epice.getQuantity()));
    }

    public void addLevure(Ingredient levure) {
        this.levures.add(levure.getName());
        this.levuresQuantity.add(String.valueOf(levure.getQuantity()));
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public Calendar getCalendarBrassage() {
        return calendarBrassage;
    }

    public void setCalendarBrassage(Calendar calendarBrassage) {
        this.calendarBrassage = calendarBrassage;
    }



}
