package com.energee3.stage.companyVehicles.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
	public Manufacturer findManufacturerByName(String name);
}
