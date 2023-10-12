package com.ekwateur.facturation.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
@Component
public abstract class Client {

    @Id
    public String clientId;
    public String typeTarif;    

    public String getClientId() {
        return clientId;
    }

    public String getTypeTarif() {
        return typeTarif;
    }
    
}
