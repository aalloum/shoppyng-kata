package com.olbati;

import java.math.BigDecimal;

public class Produit {

    private final String nom;
    private final BigDecimal prix;

    public Produit(String nom, BigDecimal prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }
}
