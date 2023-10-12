package com.ekwateur.facturation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ekwateur.facturation.model.Client;
import com.ekwateur.facturation.model.ClientParticulier;
import com.ekwateur.facturation.model.ClientPro;
import com.ekwateur.facturation.model.Consommation;
import com.ekwateur.facturation.repo.ClientRepository;
import com.ekwateur.facturation.repo.ConsommationRepository;

import jakarta.annotation.PostConstruct;

@Component
public class InitData {

    @Autowired
    public ClientRepository cRepo;
    @Autowired
    public ConsommationRepository consRepo;

    @PostConstruct
    public void init(){
        // create data for particulier
        Client particulier1 = new ClientParticulier(1, "M.", "Dupont", "Henri");
        cRepo.save(particulier1);
        Client particulier1Retrieved = cRepo.findByClientId("EKW1");
        System.out.println(particulier1Retrieved.toString());
        
        Consommation cons1 = new Consommation(particulier1.getClientId(), 1000f, 2000f, 10, 2023);
        consRepo.save(cons1);
        Consommation cons1retrieved = consRepo.findByClientIdAndMonthDateAndYearDate(particulier1.getClientId(), 10, 2023);
        System.out.println(cons1retrieved);

        // create data for proA
        Client proA = new ClientPro(2, 123456790, "Le Bon Mojo", 40000);
        cRepo.save(proA);
        Client proARetrieved = cRepo.findByClientId("EKW2");
        System.out.println(proARetrieved.toString());
        
        Consommation cons2 = new Consommation(proA.getClientId(), 1000f, 2000f, 10, 2023);
        consRepo.save(cons2);
        Consommation cons2retrieved = consRepo.findByClientIdAndMonthDateAndYearDate(proA.getClientId(), 10, 2023);
        System.out.println(cons2retrieved);

        // create data for proB
        Client proB = new ClientPro(3, 987654321, "Le Grand", 4000000);
        cRepo.save(proB);
        Client proBRetrieved = cRepo.findByClientId("EKW3");
        System.out.println(proBRetrieved.toString());
        
        Consommation cons3 = new Consommation(proB.getClientId(), 1000f, 2000f, 10, 2023);
        consRepo.save(cons3);
        Consommation cons3retrieved = consRepo.findByClientIdAndMonthDateAndYearDate(proB.getClientId(), 10, 2023);
        System.out.println(cons3retrieved);

    }
}
