package com.energee3.stage.companyVehicles.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="utilization")
public class Utilization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id", referencedColumnName = "id",  nullable = false)
	private Bookings bookingId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT TIMESTAMP", nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "end_date", nullable = false)
	private Date endDate;
	
	@Column(name="km", precision = 10, scale = 2, nullable = false)
	private BigDecimal km;
	
	@Column(name="text")
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bookings getBookingId() {
		return bookingId;
	}

	public void setBookingId(Bookings bookingId) {
		this.bookingId = bookingId;
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

	public BigDecimal getKm() {
		return km;
	}

	public void setKm(BigDecimal km) {
		this.km = km;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
