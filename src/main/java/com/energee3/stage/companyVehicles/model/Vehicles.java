package com.energee3.stage.companyVehicles.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicles {
	
	@Id
	@Column(name = "license_plate")
	private String id;
	
	//@OneToMany(mappedBy = "vehicleId")
	//private Set<Bookings> vehicles;
}
