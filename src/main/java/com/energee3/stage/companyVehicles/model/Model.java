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

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@ManyToOne
	@JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)
	private Manufacturer manufacturerId;
	
	@OneToMany(mappedBy = "modelId", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	private Set<Vehicles> vehicles;
	
	/**
	 * CONSTRUCTORS
	 */
	
	public Model() {
	}
	
	public Model(String name, Integer yearProd, Manufacturer manufacturerId) {
		this.name = name;
		this.yearProd = yearProd;
		this.manufacturerId = manufacturerId;
	}


	/**
	 * GETTERS AND SETTERS
	 */

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

	public Integer getManufacturerId() {
		return manufacturerId.getId();
	}

	public void setManufacturerId(Manufacturer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/*
	public Set<Vehicles> getVehicles() {
		return vehicles;
	}
	*/

	public void setVehicles(Set<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
