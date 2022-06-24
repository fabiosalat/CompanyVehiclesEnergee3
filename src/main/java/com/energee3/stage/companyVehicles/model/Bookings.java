package com.energee3.stage.companyVehicles.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id",  nullable = false)
	private Employees employeeId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "vehicle_id", referencedColumnName = "license_plate", columnDefinition = "VARCHAR(7)", nullable = false)
	private Vehicles vehicleId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT TIMESTAMP", nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "end_date", nullable = false)
	private Date endDate;
	
	@OneToMany(mappedBy = "bookingId")
	private Set<Utilization> utilizations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employees getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employees employeeId) {
		this.employeeId = employeeId;
	}

	public Vehicles getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Vehicles vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
