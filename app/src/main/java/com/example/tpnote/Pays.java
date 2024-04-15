package com.example.tpnote;

import java.io.Serializable;

public class Pays implements Serializable {


    private String nom;
    private String capitale;
    private int superficie;
    private String description;
    private int image;

    Pays (String nom, String capitale, int superficie, int image, String description) {
        this.nom = nom;
        this.capitale = capitale;
        this.superficie = superficie;
        this.image = image;
        this.description = description;
    }

    public void setNom(String nom) {this.nom = nom;}
    public void setCapitale(String capitale) {this.capitale = capitale;}
    public void setSuperficie(int superficie) {this.superficie = superficie;}
    public void setDescription(String description) {this.description = description;}
    public void setImage(int image) {this.image = image;}
    public String getNom() {return nom;}
    public String getCapitale() {return capitale;}
    public int getSuperficie() {return superficie;}

    public String getDescription() {return description;}

    public int getImage() {return image;}
}
