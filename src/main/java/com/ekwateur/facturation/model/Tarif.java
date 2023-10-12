package com.ekwateur.facturation.model;

// TODO: type de tarifs dans application.yml
public enum Tarif {
    TarifPart ("tarifPart"),
    TarifProA ("tarifProA"),
    TarifProB ("tarifProB");

    private String nom;

    Tarif(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
