package com.energee3.stage.companyVehicles.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Utilization;
import com.energee3.stage.companyVehicles.repository.BookingsRepository;
import com.energee3.stage.companyVehicles.repository.CustomCrudRepository;
import com.energee3.stage.companyVehicles.repository.EmployeesRepository;
import com.energee3.stage.companyVehicles.repository.ManufacturerRepository;
import com.energee3.stage.companyVehicles.repository.ModelRepository;
import com.energee3.stage.companyVehicles.repository.UtilizationRepository;
import com.energee3.stage.companyVehicles.repository.VehiclesRepository;

@RestController
@RequestMapping("/put")
public class PutController {

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
	
	@PutMapping("/employees/updatePhone/{id}")
	public Employees updateEmployeePhone(@RequestBody Employees newEmployeeData, @PathVariable Integer id) {
		Employees employee = employees.findById(id).get();
		employee.setPhoneNumber(newEmployeeData.getPhoneNumber());
		return employees.save(employee);
	}

	@PutMapping("/employees/updateEmail/{id}")
	public Employees updateEmployeeEmail(@Valid @RequestBody Employees newEmployeeData, @PathVariable Integer id) {
		Employees employee = employees.findById(id).get();
		employee.setEmail(newEmployeeData.getEmail());
		return employees.save(employee);
	}
	
	@PutMapping("/utilization/updateNote/{id}")
	public Utilization updateNote(@RequestBody Utilization note, @PathVariable Integer id) {
		Utilization util = utilization.findById(id).get();
		util.setNote(note.getNote());
		return utilization.save(util);
	}
}
