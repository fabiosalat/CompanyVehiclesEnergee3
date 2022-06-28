package com.energee3.stage.companyVehicles.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.energee3.stage.companyVehicles.model.Bookings;
import com.energee3.stage.companyVehicles.model.Employees;
import com.energee3.stage.companyVehicles.model.Vehicles;

public interface BookingsRepository extends CrudRepository<Bookings, Integer> {
	@Procedure("new_booking")
	public int insertNewBooking(@Param("employee") Integer employee, 
			@Param("vehicle") String targa, @Param("start_d") Timestamp start, @Param("end_d") Timestamp end);

	public List<Bookings> findAllBookingsByEmployeeId(Employees employeeId);
	
	public List<Bookings> findAllBookingsByVehicleId(Vehicles vehicleId);
	
	public List<Bookings> findAllBookingsByStartDateBetween(Timestamp startDate, Timestamp endDate);

}
