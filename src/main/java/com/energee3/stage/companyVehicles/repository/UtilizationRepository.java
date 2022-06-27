package com.energee3.stage.companyVehicles.repository;

import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Utilization;

public interface UtilizationRepository extends CrudRepository<Utilization, Integer> {
	
}
