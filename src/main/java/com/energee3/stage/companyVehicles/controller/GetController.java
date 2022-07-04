package com.energee3.stage.companyVehicles.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.naming.directory.SearchControls;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	private CustomCrudRepository customRepository;
	

	@GetMapping("/available/{start_d}&{end_d}")
	@Transactional
	public List<Vehicles> getAvailableVehicles(@PathVariable("start_d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startD, 
			@PathVariable("end_d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endD){
		Timestamp startDate = Timestamp.valueOf(startD);
		Timestamp endDate = Timestamp.valueOf(endD);
		return vehicles.getAvailableVehicles(startDate, endDate);
	}

	/*
	 * available con il json
	
	@GetMapping("/available") 
	@Transactional
	public List<Vehicles> getAvailableVehicles(@RequestBody Bookings json){
		return vehicles.getAvailableVehicles(json.getStartDate(), json.getEndDate());
	}
	
	*/
	
	@GetMapping("/utilizationsByBookingId/{booking_id}")
	public List<Utilization> getUtilizationsByBookingId(@PathVariable("booking_id") Bookings booking_id){
		return utilization.findAllUtilizationByBookingId(booking_id);
	}
	
	@GetMapping("/bookings")
	public Iterable<Bookings> getAllBookings(){
		return bookings.findAll();
	}
	
//	
//	@GetMapping("/bookingsById/{booking_id}")
//	public Bookings getBookingsById(@PathVariable("booking_id") Integer bookingId) {
//		return bookings.findById(bookingId).get();
//	}

	
//	@GetMapping("/bookingsByEmployeeId/{employee_id}")
//	public List<Bookings> getBookingsByEmployeeId(@PathVariable("employee_id") Employees employeeId) {
//		return bookings.findAllBookingsByEmployeeId(employeeId);
//	}

	@GetMapping("/employees")
	public Iterable<Employees> getAllEmployees(){
		return employees.findAll();
	}
	
	@GetMapping("/employeesById/{employee_id}")
	public Employees getEmployeesById(@PathVariable("employee_id") Integer employeeId){
		return employees.findById(employeeId).get();
	}
	
	@GetMapping("/manufacturer")
	public Iterable<Manufacturer> getAllManufacturers(){
		return manufacturer.findAll();
	}
	
	@GetMapping("/models")
	public Iterable<Model> getAllModels(){
		return model.findAll();
	}
	
	@GetMapping("/modelByManufacturer/{manufacturer}")
	public List<Model> getModelsByManufacturer(@PathVariable("manufacturer") String manufacturerName){
		Manufacturer manufacturerRecord = new Manufacturer();
		manufacturerRecord = manufacturer.findManufacturerByName(manufacturerName);
		Integer id = manufacturerRecord.getId();
		Manufacturer manufacturerId = new Manufacturer();
		manufacturerId.setId(id);
		return model.findModelsByManufacturerId(manufacturerId);
	}

	@GetMapping("/vehicles")
	public Iterable<Vehicles> getAllVehicles(){
		return vehicles.findAll();
	}
	
	@GetMapping("/vehicleById/{license_plate}")
	public Vehicles getVehicleByLicensePlate(@PathVariable("license_plate") String licensePlate) {
		return vehicles.findById(licensePlate).get();
	}
	
	@GetMapping("/getVehiclesByFilter")
	public List<Vehicles> getVehiclesByFilter(@RequestBody Vehicles searchVehicle){
			return vehicles.findAll(Example.of(new Vehicles(searchVehicle.getId(), searchVehicle.getFuel(), searchVehicle.getModelId())));
		
	}
	
	@GetMapping("/getBookingsByFilter")
	public List<Bookings> getBookingsByFilter(@RequestBody Bookings searchBooking){
		Bookings b = new Bookings();
		b.setEmployeeId(employees.findById(searchBooking.getEmployeeId()).get());
		b.setId(searchBooking.getId());
		b.setVehicleId(vehicles.findById(searchBooking.getVehicleId()).get());
		
//		b.setStartDate(searchBooking.getStartDate());
//		b.setEndDate(searchBooking.getEndDate());
		
		if (searchBooking.getStartDate() != null && searchBooking.getEndDate() != null) {
			bookings.getBookingsByPeriod(searchBooking.getStartDate(), searchBooking.getEndDate());
		}
		
		
		return bookings.findAll(Example.of(b));
		
	}
	
	
	
}
