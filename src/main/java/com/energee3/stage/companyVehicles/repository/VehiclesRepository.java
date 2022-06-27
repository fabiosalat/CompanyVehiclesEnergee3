package com.energee3.stage.companyVehicles.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Vehicles;

public interface VehiclesRepository extends CrudRepository<Vehicles, Integer> {
	@Query(value = "CALL available(:start_d, :end_d);", nativeQuery = true)
	public List<Vehicles> getAvailableVehicles(LocalDateTime start_d, LocalDateTime end_d);

	/*
	@Query(value = "CALL myStoredProcedure(:targa);", nativeQuery = true)
	public Vehicles provaProcedure(String targa);
	
	@Procedure("myStoredProcedure")
	public Vehicles provaProcedure2(String targa);
	*/
	
	
	@Query(value = "CALL history(:car_plate);", nativeQuery = true)
	public Iterable<Object[]> history(String car_plate);
	

}
