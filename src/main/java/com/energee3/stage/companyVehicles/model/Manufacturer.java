package com.energee3.stage.companyVehicles.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
	
	@Id
	private Integer id;


}
