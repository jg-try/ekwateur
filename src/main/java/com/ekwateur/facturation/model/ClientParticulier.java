package com.ekwateur.facturation.model;

import jakarta.persistence.Entity;

@Entity
public class ClientParticulier extends Client {
    public String civilite;
    public String nom;
    public String prenom;

    public ClientParticulier(){

    }

    public ClientParticulier(long id, String civilite, String nom, String prenom){
        // TODO: l'ID devrait être créé au moment de la création du compte
        this.clientId = "EKW" + id;
        this.civilite  = civilite;
        this.nom = nom;
        this.prenom = prenom;
        // TODO: le type de tarif devrait être ajouté au moment de la création du compte
        this.typeTarif = Tarif.TarifPart.getNom();
    }


    @Override
    public String toString() {
      return String.format(
          "Client[clientId=%s, civilite='%s', nom='%s', prenom='%s'] ",
          this.clientId, civilite, nom, prenom);
    }
}
