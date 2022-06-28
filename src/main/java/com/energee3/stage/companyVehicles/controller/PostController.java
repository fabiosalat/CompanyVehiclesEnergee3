package com.energee3.stage.companyVehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Manufacturer;
import com.energee3.stage.companyVehicles.model.Model;
import com.energee3.stage.companyVehicles.model.Utilization;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.repository.BookingsRepository;
import com.energee3.stage.companyVehicles.repository.CustomCrudRepository;
import com.energee3.stage.companyVehicles.repository.EmployeesRepository;
import com.energee3.stage.companyVehicles.repository.ManufacturerRepository;
import com.energee3.stage.companyVehicles.repository.ModelRepository;
import com.energee3.stage.companyVehicles.repository.UtilizationRepository;
import com.energee3.stage.companyVehicles.repository.VehiclesRepository;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private BookingsRepository bookings;
	@Autowired
	private EmployeesRepository employees;
	@Autowired
	private ManufacturerRepository manufacturer;
	@Autowired
	private ModelRepository model;
	@Autowired
	private UtilizationRepository utilization;
	@Autowired
	private VehiclesRepository vehicles;
	@Autowired
	private CustomCrudRepository customRepository;
	
	
	@PostMapping("/newBooking")
	@Transactional
	public int newBooking(@RequestBody Bookings newBooking) {
		return bookings.insertNewBooking(newBooking.getEmployeeId(), newBooking.getVehicleId(), newBooking.getStartDate(), newBooking.getEndDate());
	}
	
	@PostMapping("/newKmNote")
	@Transactional
	public void newKmNote(@RequestBody Utilization util) {
		utilization.insertKmNote(util.getBookingId(), util.getStartDate(), util.getEndDate(), util.getKm(), util.getNote());
	}
	
	@PostMapping(value = "/insertKmNote")
	public void insertKmNote(@RequestBody Utilization newUtilization) {
		utilization.save(newUtilization);
	}
	
	@PostMapping("/newEmployee")
	public Employees insertNewEmployee(@RequestBody Employees newEmployee) {
		return employees.save(newEmployee);
		
	}
	
	@PostMapping("/newVehicle")
	public Vehicles insertNewVehicle(@RequestBody Vehicles newVehicles) {
		return vehicles.save(newVehicles);
		
	}
	
	@PostMapping("/newManufacturer")
	public Manufacturer insertNewManufacturer(@RequestBody Manufacturer newManufacturer) {
		return manufacturer.save(newManufacturer);
		
	}
	
	@PostMapping("/newModel")
	public Model insertNewModel(@RequestBody Model newModel) {
		return model.save(newModel);
		
	}
	
	
}
