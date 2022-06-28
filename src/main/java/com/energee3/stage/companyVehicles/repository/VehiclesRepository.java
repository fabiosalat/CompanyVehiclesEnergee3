package com.energee3.stage.companyVehicles.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Model;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.model.Vehicles.Fuel;

public interface VehiclesRepository extends CrudRepository<Vehicles, Integer> {
	@Procedure("available")
	public List<Vehicles> getAvailableVehicles(Timestamp start_d, Timestamp end_d);	

	public Vehicles findVehiclesById (String id);
	
	public List<Vehicles> findVehiclesByFuel(Fuel fuel);
	
	public List<Vehicles> findVehiclesByModelId(Model modelId);
	
	public List<Vehicles> findVehiclesByModelIdIn(List<Model> ModelIds);
}
