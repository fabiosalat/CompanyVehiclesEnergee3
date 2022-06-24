package com.energee3.stage.companyVehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Vehicles;

public interface BookingsRepository extends CrudRepository<Bookings, Integer> {
	@Procedure("history")
	public List<Bookings> getHistory(String plate);

}
