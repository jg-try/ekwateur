package com.ekwateur.facturation.facturation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ekwateur.facturation.model.Client;
import com.ekwateur.facturation.model.ClientParticulier;
import com.ekwateur.facturation.model.ClientPro;
import com.ekwateur.facturation.model.Consommation;
import com.ekwateur.facturation.repo.ClientRepository;
import com.ekwateur.facturation.repo.ConsommationRepository;
import com.ekwateur.facturation.repo.Prix_10_2023;

@Component
public class Facturation {

    @Autowired
    public ClientRepository cRepo;
    @Autowired
    public ConsommationRepository consRepo;
    @Autowired
    public Prix_10_2023 prix;
    
    public Map<String, Float> getFacturation (String id, int month, int year){
        Map<String, Float> consumptions = new HashMap<>();
        Client client = cRepo.findByClientId(id);
        if (client != null) {
            Consommation cons = consRepo.findByClientIdAndMonthDateAndYearDate(client.getClientId(), month, year);
            if (cons != null){
                if (client instanceof ClientPro){
                    consumptions = proFacturation((ClientPro) client, cons);
                } else if (client instanceof ClientParticulier){
                    consumptions = partFacturation((ClientParticulier) client, cons);
                }
            } else {
                // TODO: consommation not found
            }
        } else {
            // TODO: client not found
        }
        return consumptions;
    }

    private Map<String, Float> proFacturation(ClientPro client, Consommation cons){
        // TODO: traitement différencié pour les pros
        Map<String, Float> consumptions = new HashMap<>();
        consumptions.put("FactureElec", cons.getConsommationElec() * prix.getPrixElecMap().get(client.getTypeTarif()));
        consumptions.put("FactureGaz", cons.getConsommationGaz() * prix.getPrixGazMap().get(client.getTypeTarif()));
        return consumptions;
    }

    private Map<String, Float> partFacturation(ClientParticulier client, Consommation cons){
        // TODO: traitement différencié pour les particuliers
        Map<String, Float> consumptions = new HashMap<>();
        consumptions.put("FactureElec", cons.getConsommationElec() * prix.getPrixElecMap().get(client.getTypeTarif()));
        consumptions.put("FactureGaz", cons.getConsommationGaz() * prix.getPrixGazMap().get(client.getTypeTarif()));
        return consumptions;
    }
    

}
