package com.energee3.stage.companyVehicles.model;

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
@Table(name="model")
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String name;
	
	@Column(name = "year_prod", nullable = false)
	private Integer yearProd;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manufacturer_id", referencedColumnName = "id",  nullable = false)
	private Manufacturer manufacturerId;
	
	@OneToMany(mappedBy = "modelId")
	private Set<Vehicles> vehicles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearProd() {
		return yearProd;
	}

	public void setYearProd(Integer yearProd) {
		this.yearProd = yearProd;
	}

	public Manufacturer getManufacturer() {
		return manufacturerId;
	}

	public void setManufacturer(Manufacturer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/*public Set<Vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}*/
	
	
}
