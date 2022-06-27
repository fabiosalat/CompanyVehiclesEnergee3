package com.energee3.stage.companyVehicles.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
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
@RequestMapping("/get")
public class GetController {

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
	private CustomCrudRepository customRepository;
	
	@GetMapping("/getBookings")
	public Iterable<Bookings> getAllBookings(){
		return bookings.findAll();
	}
	
	@GetMapping("/getEmployees")
	public Employees getAllEmployees(){
		return employees.findById(1).get();
	}
	
	@GetMapping("/available")
	public List<Vehicles> getAvailableVehicles(){
		return vehicles.getAvailableVehicles(LocalDateTime.now(), LocalDateTime.of(2022, 06, 28, 8, 0));
	}
	
	@GetMapping("/getHistory")
	@Transactional
	public List<Map<String, Object>> getHistory(@RequestParam("license_plate") String licensePlate) {
		return customRepository.getHistory(licensePlate);
	}
	
	@GetMapping("/newBooking")
	@Transactional
	public int newBooking() {
		return bookings.insertNewBooking(1, "WGHBGHR", LocalDateTime.now(), LocalDateTime.of(2022, 06, 28, 8, 0));
	}
	
	@GetMapping("/getUtilization")
	public Iterable<Utilization> getUtilization(){
		return utilization.findAll();
	}
	
	
}