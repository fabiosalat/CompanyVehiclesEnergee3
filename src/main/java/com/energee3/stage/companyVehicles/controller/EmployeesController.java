package com.energee3.stage.companyVehicles.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.repository.EmployeesRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	@Autowired
	private EmployeesRepository employees;

	
	@GetMapping("/findAll")
	public Iterable<Employees> getAllEmployees(){
		return employees.findAll();
	}
	
	@GetMapping("/findById/{employee_id}")
	public Employees getEmployeesById(@PathVariable("employee_id") Integer employeeId){
		return employees.findById(employeeId).get();
	}
	
	@GetMapping("/findByFilter")
	public List<Employees> getEmployeesByFilter(@RequestBody Employees searchEmployee){
		Employees e = new Employees();
		e.setId(searchEmployee.getId());
		e.setFirstName(searchEmployee.getFirstName());
		e.setLastName(searchEmployee.getLastName());
		return employees.findAll(Example.of(e));
	}

	@PostMapping("/newEmployee")
	public Employees insertNewEmployee(@RequestBody Employees newEmployee) {
		return employees.save(newEmployee);
	}
	
	@PutMapping("/updatePhone/{id}")
	public Employees updateEmployeePhone(@RequestBody Employees newEmployeeData, @PathVariable Integer id) {
		Employees employee = employees.findById(id).get();
		employee.setPhoneNumber(newEmployeeData.getPhoneNumber());
		return employees.save(employee);
	}

	@PutMapping("/updateEmail/{id}")
	public Employees updateEmployeeEmail(@Valid @RequestBody Employees newEmployeeData, @PathVariable Integer id) {
		Employees employee = employees.findById(id).get();
		employee.setEmail(newEmployeeData.getEmail());
		return employees.save(employee);
	}
	
	@PutMapping("/updateActive/{id}")
	public Employees updateActiveEmployee(@RequestBody Employees newEmployeeData, @PathVariable Integer id) {
		Employees employee = employees.findById(id).get();
		employee.setActive(newEmployeeData.getActive());
		return employees.save(employee);
	}
	
}
