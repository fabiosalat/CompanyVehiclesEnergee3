package com.energee3.stage.companyVehicles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "first_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String lastName;
	
	//Sistemare controlli
	@Column(name="sex")
	private String sex;
	
	@Column(name = "phone_number", columnDefinition = "VARCHAR(10)", nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
	private String email;
	
	@Column(name = "tax_code", columnDefinition = "VARCHAR(16)", nullable = false, unique = true)
	private String taxCode;
	
	@OneToMany(mappedBy = "employeeId")
	private Set bookings;
}
