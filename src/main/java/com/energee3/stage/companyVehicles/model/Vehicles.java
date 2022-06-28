package com.energee3.stage.companyVehicles.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicles {
	public enum Fuel{
		Diesel, Benzina, GPL, Metano, Hybrid, Electric
	}
	
	@Id
	@Column(name = "license_plate", columnDefinition = "VARCHAR(7)")
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fuel", nullable = false)
	private Fuel fuel;
	
	@ManyToOne
	@JoinColumn(name = "model_id", referencedColumnName = "id",  nullable = false)
	private Model modelId;
	
	@OneToMany(mappedBy = "vehicleId")
	private Set<Bookings> bookings;
	
	/**
	 * CONSTRUCTORS
	 */

	public Vehicles() {
	}

	public Vehicles(String id, Fuel fuel, Model modelId) {
		this.id = id;
		this.fuel = fuel;
		this.modelId = modelId;
	}
	
	/**
	 * GETTERS AND SETTERS
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
		
	public Integer getModelId() {
		return modelId.getId();
	}

	public void setModelId(Model modelId) {
		this.modelId = modelId;
	}

	/*
	public Set<Bookings> getBookings() {
		return bookings;
	}
	*/

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}
	
	
}