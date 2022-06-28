package com.energee3.stage.companyVehicles.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
	public List<Employees> findAllEmployeesByFirstNameAndLastName(String firstName, String lastName);
}
