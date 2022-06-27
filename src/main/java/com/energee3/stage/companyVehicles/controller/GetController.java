package com.energee3.stage.companyVehicles.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	private CustomCrudRepository customRepository;
	
	
	@GetMapping("/available")
	@Transactional
	public List<Vehicles> getAvailableVehicles(){
		return vehicles.getAvailableVehicles(LocalDateTime.now(), LocalDateTime.of(2022, 06, 28, 8, 0));
	}
	
	@GetMapping("/history")
	@Transactional
	public List<Map<String, Object>> getHistory(@PathVariable("license_plate") String licensePlate) {
		return customRepository.getHistory(licensePlate);
	}
	
	@GetMapping("/utilization")
	public Iterable<Utilization> getUtilizations(){
		return utilization.findAll();
	}
	
	@GetMapping("/utilizationById")
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
	
	/*@GetMapping("/bookingsByVehicleId/{vehicle_id}")
	public List<Bookings> getBookingsByVehicleId(@PathVariable("vehicle_id") Vehicles vehicleId) {
		return bookings.findAllBookingsByVehicleId(vehicleId);
	}*/
	
	
	//Servirebbe un find between
	/*@GetMapping("/bookingsByPeriod/{start_d}")
	public List<Bookings> getBookingsByPeriod(@PathVariable("start_d") Timestamp startDate, @PathVariable("end_d") Timestamp endDate) {
		return bookings.findAllBookingsByStartDate(startDate, endDate);
	}*/
	
	@GetMapping("/employees")
	public Employees getAllEmployees(){
		return employees.findById(1).get();
	}

	

}
