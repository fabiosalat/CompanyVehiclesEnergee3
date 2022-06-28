package com.energee3.stage.companyVehicles.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Manufacturer;
import com.energee3.stage.companyVehicles.model.Model;
import com.energee3.stage.companyVehicles.model.Utilization;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.model.Vehicles.Fuel;
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
	

//	@GetMapping("/available/{start_d}/{end_d}")
//	@Transactional
//	public List<Vehicles> getAvailableVehicles(@PathVariable("start_d") Timestamp startDate, @PathVariable("end_d") Timestamp endDate){
//		return vehicles.getAvailableVehicles(startDate, endDate);
//	}
	
	@GetMapping("/history/{license_plate}")
	@Transactional
	public List<Map<String, Object>> getHistory(@PathVariable("license_plate") String licensePlate) {
		return customRepository.getHistory(licensePlate);
	}
	
	@GetMapping("/utilization")
	public Iterable<Utilization> getUtilizations(){
		return utilization.findAll();
	}
	
	@GetMapping("/utilizationById/{utilization_id}")
	public Utilization getUtilizationById(@PathVariable("utilization_id") Integer utilizationId) {
		return utilization.findById(utilizationId).get();
	}
	
	@GetMapping("/bookings")
	public Iterable<Bookings> getAllBookings(){
		return bookings.findAll();
	}
	
	@GetMapping("/bookingsById/{booking_id}")
	public Bookings getBookingsById(@PathVariable("booking_id") Integer bookingId) {
		return bookings.findById(bookingId).get();
	}
	
	@GetMapping("/bookingsByEmployeeId/{employee_id}")
	public List<Bookings> getBookingsByEmployeeId(@PathVariable("employee_id") Employees employeeId) {
		return bookings.findAllBookingsByEmployeeId(employeeId);
	}
	
	@GetMapping("/bookingsByVehicleId/{vehicle_id}")
	public List<Bookings> getBookingsByVehicleId(@PathVariable("vehicle_id") String vehicleId) {
		Vehicles myVehicle = new Vehicles();
		myVehicle.setId(vehicleId);
		return bookings.findAllBookingsByVehicleId(myVehicle);
	}
		
	
//	@GetMapping("/bookingsByPeriod/{start_d}/{end_d}")
//	public List<Bookings> getBookingsByPeriod(@PathVariable("start_d") Timestamp startDate, @PathVariable("end_d") Timestamp endDate) {
//		return bookings.findAllBookingsByStartDateBetween(startDate, endDate);
//	}
	
	@GetMapping("/employees")
	public Iterable<Employees> getAllEmployees(){
		return employees.findAll();
	}
	
	@GetMapping("/employeesById/{employee_id}")
	public Employees getEmployeesById(@PathVariable("employee_id") Integer employeeId){
		return employees.findById(employeeId).get();
	}
	
	@GetMapping("/employeesByName/{first_name}/{last_name}")
	public List<Employees> getEmployeesByName(@PathVariable("first_name") String firstName, @PathVariable("last_name") String lastName) {
		return employees.findAllEmployeesByFirstNameAndLastName(firstName, lastName);
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
	
	
	@GetMapping("/modelByYear/{year}")
	public List<Model> getModelByYear(@PathVariable("year") Integer yearProd){
		return model.findModelByYearProd(yearProd);
	}
	
	@GetMapping("/vehicles")
	public Iterable<Vehicles> getAllVehicles(){
		return vehicles.findAll();
	}
	
	@GetMapping("/vehicleById/{license_plate}")
	public Vehicles getVehicleByLicensePlate(@PathVariable("license_plate") String licensePlate) {
		return vehicles.findVehiclesById(licensePlate);
	}
	
	@GetMapping("/vehiclesByFuel/{fuel}")
	public List<Vehicles> getVehiclesByFuel(@PathVariable("fuel") Fuel fuel){
		return vehicles.findVehiclesByFuel(fuel);
	}
	
	@GetMapping("/vehiclesByModel/{my_model}")
	public List<Vehicles> getVehiclesByModel(@PathVariable("my_model") String myModel) {
		Model modelRecord = new Model();
		modelRecord = model.findModelByName(myModel);
		Integer id = modelRecord.getId();
		Model modelId = new Model();
		modelId.setId(id);
		return vehicles.findVehiclesByModelId(modelId);
	}
	
	@GetMapping("/vehiclesByYearProd/{year}")
	public List<Vehicles> getVehiclesByYearProd(@PathVariable("year") Integer yearProd) {
		List<Model> modelRecords =  model.findModelByYearProd(yearProd);
		List<Model> modelIds = new ArrayList<Model>();
		for(Model auto : modelRecords) {
			Integer id = auto.getId();
			Model modelId = new Model();
			modelId.setId(id);
			modelIds.add(modelId);
		}
		return vehicles.findVehiclesByModelIdIn(modelIds);
	}
}
