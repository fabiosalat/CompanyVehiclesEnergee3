package com.energee3.stage.companyVehicles.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.repository.BookingsRepository;
import com.energee3.stage.companyVehicles.repository.EmployeesRepository;
import com.energee3.stage.companyVehicles.repository.ManufacturerRepository;
import com.energee3.stage.companyVehicles.repository.ModelRepository;
import com.energee3.stage.companyVehicles.repository.UtilizationRepository;
import com.energee3.stage.companyVehicles.repository.VehiclesRepository;

@RestController
@RequestMapping("/")
public class Controller {

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
	
	/*
	@GetMapping("/testProcedure")
	public Vehicles testProcedure() {
		return vehicles.provaProcedure("OLKIHYG");
	}
	
	@GetMapping("/testProcedure2")
	@Transactional
	public Vehicles testProcedure2() {
		return vehicles.provaProcedure2("WGHBGHR");
	}
	*/
	
	@GetMapping("/getHistory")
	@Transactional
	public List<Bookings> getHistory() {
		return bookings.getHistory("WGHBGHR");
	}
	
	
}
