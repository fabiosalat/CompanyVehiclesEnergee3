package com.energee3.stage.companyVehicles.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Utilization;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.repository.BookingsRepository;
import com.energee3.stage.companyVehicles.repository.UtilizationRepository;
import com.energee3.stage.companyVehicles.repository.VehiclesRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

	@Autowired
	private BookingsRepository bookings;
	@Autowired
	private UtilizationRepository utilization;
	@Autowired
	private VehiclesRepository vehicles;
	
	
	@GetMapping("/findAll")
	public Iterable<Bookings> getAllBookings(){
		return bookings.findAll();
	}
	
	@GetMapping("/available/{start_d}&{end_d}")
	@Transactional
	public List<Vehicles> getAvailableVehicles(@PathVariable("start_d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startD, 
			@PathVariable("end_d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endD){
		Timestamp startDate = Timestamp.valueOf(startD);
		Timestamp endDate = Timestamp.valueOf(endD);
		return vehicles.getAvailableVehicles(startDate, endDate);
	}

	@GetMapping("/utilizationsByBookingId/{booking_id}")
	public List<Utilization> getUtilizationsByBookingId(@PathVariable("booking_id") Bookings booking_id){
		return utilization.findAllUtilizationByBookingId(booking_id);
	}
	
	@GetMapping("/findById/{booking_id}")
	public Bookings getBookingsById(@PathVariable("booking_id") Integer bookingId) {
		return bookings.findById(bookingId).get();
	}

	@GetMapping("/findByEmployeeId/{employee_id}")
	public List<Bookings> getBookingsByEmployeeId(@PathVariable("employee_id") Employees employeeId) {
		return bookings.findAllBookingsByEmployeeId(employeeId);
	}
	
	@PostMapping("/newBooking")
	@Transactional
	public int newBooking(@Valid @RequestBody Bookings newBooking) {
		return bookings.insertNewBooking(newBooking.getEmployeeId(), newBooking.getVehicleId(), newBooking.getStartDate(), newBooking.getEndDate());
	}
	
	@PostMapping("/insertKmNote")
	public void insertKmNote(@RequestBody Utilization newUtilization) {
		utilization.save(newUtilization);
	}
	
	@PutMapping("/updateUtilizationNote/{id}")
	public Utilization updateNote(@RequestBody Utilization note, @PathVariable Integer id) {
		Utilization util = utilization.findById(id).get();
		util.setNote(note.getNote());
		return utilization.save(util);
	}
	
	
}
