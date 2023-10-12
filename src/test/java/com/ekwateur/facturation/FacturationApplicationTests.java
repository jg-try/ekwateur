package com.ekwateur.facturation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.ekwateur.facturation.facturation.FacturationAPI;
import com.ekwateur.facturation.model.Client;
import com.ekwateur.facturation.model.ClientParticulier;
import com.ekwateur.facturation.model.ClientPro;
import com.ekwateur.facturation.model.Consommation;
import com.ekwateur.facturation.repo.ClientRepository;
import com.ekwateur.facturation.repo.ConsommationRepository;

@SpringBootTest
class FacturationApplicationTests {

	@Autowired
	public FacturationAPI facturationAPI;
    @Autowired
    public ClientRepository cRepo;
    @Autowired
    public ConsommationRepository consRepo;

	@BeforeTestClass
    public void init() {
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

	@Test
	void testFacturationParticulierAPI() {
		ResponseEntity<Map<String, Float>> resp = facturationAPI.getCustomerById("EKW1", 10, 2023);
		Map<String, Float> truth = new HashMap<>();
		truth.put("FactureGaz", 115.0f);
		truth.put("FactureElec", 242.0f);
		assertEquals(resp.getBody(), truth);
	}

	@Test
	void testFacturationProAAPI() {
		ResponseEntity<Map<String, Float>> resp = facturationAPI.getCustomerById("EKW2", 10, 2023);
		Map<String, Float> truth = new HashMap<>();
		truth.put("FactureGaz", 111.0f);
		truth.put("FactureElec", 228.0f);
		assertEquals(resp.getBody(), truth);
	}

	@Test
	void testFacturationProBAPI() {
		ResponseEntity<Map<String, Float>> resp = facturationAPI.getCustomerById("EKW3", 10, 2023);
		Map<String, Float> truth = new HashMap<>();
		truth.put("FactureGaz", 113.0f);
		truth.put("FactureElec", 236.0f);
		assertEquals(resp.getBody(), truth);
	}

	@Test
	void testFacturationInconnuAPI() {
		ResponseEntity<Map<String, Float>> resp = facturationAPI.getCustomerById("ZIZOU", 10, 2023);
		Map<String, Float> truth = new HashMap<>();
		assertEquals(resp.getBody(), truth);
	}
	

}
