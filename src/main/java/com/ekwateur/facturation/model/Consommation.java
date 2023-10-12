package com.ekwateur.facturation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consommation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
    public String clientId;
    public float consommationGaz;
    public float consommationElec;
    public int monthDate;
    public int yearDate;

    public Consommation(){

    }

    public Consommation(String clientId, float consommationGaz, float consommationElec, int monthDate, int yearDate){
        this.clientId = clientId;
        this.consommationGaz = consommationGaz;
        this.consommationElec = consommationElec;
        this.monthDate = monthDate;
        this.yearDate = yearDate;
    }

    public Consommation(Long id, String clientId, Float consommationGaz, float consommationElec, short monthDate, short yearDate){
        this.id = id;
        this.clientId = clientId;
        this.consommationGaz = consommationGaz;
        this.consommationElec = consommationElec;
        this.monthDate = monthDate;
        this.yearDate = yearDate;
    }

    public float getConsommationElec() {
        return consommationElec;
    }

    public float getConsommationGaz() {
        return consommationGaz;
    }

    @Override
    public String toString() {
        
        return String.format(
            "Consommation[clientId=%s, consommationGaz='%s', consommationElec='%s',year='%s', month='%s'] ",
            this.clientId, consommationGaz, consommationElec, yearDate, monthDate);
    }
    
}
