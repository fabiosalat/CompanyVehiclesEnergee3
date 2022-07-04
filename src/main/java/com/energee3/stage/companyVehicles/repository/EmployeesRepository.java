package com.energee3.stage.companyVehicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.energee3.stage.companyVehicles.model.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer>, JpaRepository<Employees, Integer> {
}
