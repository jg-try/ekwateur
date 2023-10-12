package com.ekwateur.facturation.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * TODO: récupérer les prix par mois dans une DB
 * 
 */
@Component
public class Prix_10_2023 {

    Map<String, Float> prixElecMap = new HashMap<>();
    Map<String, Float> prixGazMap = new HashMap<>();

    public Prix_10_2023(){
        prixElecMap.put("tarifPart", 0.121f);
        prixElecMap.put("tarifProA", 0.114f);
        prixElecMap.put("tarifProB", 0.118f);

        prixGazMap.put("tarifPart", 0.115f);
        prixGazMap.put("tarifProA", 0.111f);
        prixGazMap.put("tarifProB", 0.113f);
    }

    public Map<String, Float> getPrixElecMap() {
        return prixElecMap;
    }

    public Map<String, Float> getPrixGazMap() {
        return prixGazMap;
    }
}
