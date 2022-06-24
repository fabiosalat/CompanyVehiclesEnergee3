package com.energee3.stage.companyVehicles.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

@Entity
@Table(name="vehicles")
public class Vehicles {
	
	@OneToMany(mappedBy = "vehicleId")
	private Set vehicles;
}
