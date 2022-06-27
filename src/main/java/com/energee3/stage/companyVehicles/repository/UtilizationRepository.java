package com.energee3.stage.companyVehicles.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.energee3.stage.companyVehicles.model.Utilization;

public interface UtilizationRepository extends CrudRepository<Utilization, Integer> {
	@Procedure("insert_km_note")
	public void insertKmNote(@Param("booking") Integer bookingId, @Param("start_d") Timestamp start_d, @Param("end_d") Timestamp end_d,
			@Param("km") BigDecimal km, @Param("note") String note);

}
