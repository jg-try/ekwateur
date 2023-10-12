package com.ekwateur.facturation.repo;

import org.springframework.data.repository.CrudRepository;

import com.ekwateur.facturation.model.Consommation;

public interface ConsommationRepository extends CrudRepository<Consommation, Long> {
    
    Consommation findByClientId(String clientId);

    Consommation findByClientIdAndMonthDateAndYearDate(String clientId, int MonthDate, int YearDate);

}
