package com.energee3.stage.companyVehicles.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
	private enum Fuel{
		Diesel, Benzina, GPL, Metano, Hybrid, Electric
	}
	
	@Id
	@Column(name = "license_plate", columnDefinition = "VARCHAR(7)")
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fuel", nullable = false)
	private Fuel fuel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id", referencedColumnName = "id",  nullable = false)
	private Model modelId;
	
	@OneToMany(mappedBy = "vehicleId")
	private Set<Bookings> bookings;

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
		
	public Model getModelId() {
		return modelId;
	}

	public void setModelId(Model modelId) {
		this.modelId = modelId;
	}

	/*public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}*/
	
	
}