package com.energee3.stage.companyVehicles.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id",  nullable = false)
	private Employees employeeId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "vehicle_id", referencedColumnName = "license_plate", columnDefinition = "VARCHAR(7)", nullable = false)
	private Vehicles vehicleId;
	
	@Column(name= "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT TIMESTAMP", nullable = false)
	private Timestamp startDate;
	
	@Column(name= "end_date", nullable = false)
	private Timestamp endDate;
	
	@OneToMany(mappedBy = "bookingId")
	private Set<Utilization> utilizations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId.getId();
	}

	public void setEmployeeId(Employees employeeId) {
		this.employeeId = employeeId;
	}

	public String getVehicleId() {
		return vehicleId.getId();
	}

	public void setVehicleId(Vehicles vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	/*
	public Set<Utilization> getUtilizations() {
		return utilizations;
	}

	public void setUtilizations(Set<Utilization> utilizations) {
		this.utilizations = utilizations;
	}
	
	 */	
}
