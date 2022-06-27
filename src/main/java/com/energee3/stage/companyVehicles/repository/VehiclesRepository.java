package com.energee3.stage.companyVehicles.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Vehicles;

public interface VehiclesRepository extends CrudRepository<Vehicles, Integer> {
	@Procedure("available")
	public List<Vehicles> getAvailableVehicles(LocalDateTime start_d, LocalDateTime end_d);	

}
