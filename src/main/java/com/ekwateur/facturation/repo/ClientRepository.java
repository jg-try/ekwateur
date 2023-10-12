package com.ekwateur.facturation.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekwateur.facturation.model.Client;

public interface ClientRepository  extends CrudRepository<Client, Long> {

    Client findByClientId(String clientId);
    
}
