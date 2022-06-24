package com.energee3.stage.companyVehicles.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.energee3.stage.companyVehicles.model.Bookings;

public interface BookingsRepository extends CrudRepository<Bookings, Integer> {
	@Procedure("history")
	public List<Bookings> getHistory(String plate);
	
	@Procedure("new_booking")
	public int insertNewBooking(@Param("employee") int employee, 
			@Param("vehicle") String targa, @Param("start_d") LocalDateTime start, @Param("end_d") LocalDateTime end);

	
	
}
