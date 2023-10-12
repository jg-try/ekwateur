package com.ekwateur.facturation.facturation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturationAPI {

    @Autowired
    public Facturation facturation;

    // TODO: éventuellement un POST plutôt qu'un GET
    @GetMapping("/c/{id}/f/{month}/{year}")
	public ResponseEntity<Map<String, Float>> getCustomerById(@PathVariable String id, @PathVariable int month, @PathVariable int year) {
        Map<String, Float> fac = facturation.getFacturation(id, month, year);
		return ResponseEntity.ok(fac);
	}

}
