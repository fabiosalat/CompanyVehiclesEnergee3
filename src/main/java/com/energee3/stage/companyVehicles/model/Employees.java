package com.energee3.stage.companyVehicles.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name="employees")
public class Employees {
	private enum Sex {
		M, F, non_binary
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sex", nullable = false)
	private Sex sex;
	
	@Column(name = "phone_number", columnDefinition = "VARCHAR(10)", nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
	@Check(constraints = "email LIKE '%@%.%'")
	private String email;
	
	@Column(name = "tax_code", columnDefinition = "VARCHAR(16)", nullable = false, unique = true)
	@Check(constraints = "LENGTH(tax_code) = 16")
	private String taxCode;
	
	@OneToMany(mappedBy = "employeeId")
	private Set<Bookings> bookings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
/*
	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}
	*/
	
}
