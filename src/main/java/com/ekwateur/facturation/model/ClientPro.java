package com.ekwateur.facturation.model;

import jakarta.persistence.Entity;

@Entity
public class ClientPro extends Client {
    public long siret;
    public String raisonSociale;
    public long CA;
    public ClientPro (){

    }

    public ClientPro (long id, long siret, String raisonSociale, long CA){
        // TODO: l'ID devrait être créé au moment de la création du compte
        this.clientId = "EKW" + id;
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.CA = CA;
        if (CA < 1000000){
            // TODO: le type de tarif devrait être ajouté au moment de la création du compte
            // Si non, alors éviter ce hard coding du 1000000
            this.typeTarif = Tarif.TarifProA.getNom();
        } else {
            this.typeTarif = Tarif.TarifProB.getNom();
        }
    }

}
