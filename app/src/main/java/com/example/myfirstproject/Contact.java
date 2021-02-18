package com.example.myfirstproject;

import java.io.Serializable;

public class Contact implements Serializable {

    String nom, prenom, num;

    public Contact(String nom, String prenom, String num) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}
