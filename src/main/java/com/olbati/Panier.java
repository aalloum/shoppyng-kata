package com.olbati;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {

    private List<Produit> produits = new ArrayList<>();

    public List<Produit> consulterProduits() {
        return produits;
    }

    public void ajouterProduit(Produit produit) {
        Preconditions.checkArgument(produit != null);
        produits.add(produit);
    }

    public void supprimerProduit(String nomProduit) {
        Preconditions.checkArgument(nomProduit != null);
        produits.removeIf(produit -> (nomProduit.equals(produit.getNom())));
    }

    public BigDecimal montantTotal() {
        return produits.stream().map(Produit::getPrix).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
