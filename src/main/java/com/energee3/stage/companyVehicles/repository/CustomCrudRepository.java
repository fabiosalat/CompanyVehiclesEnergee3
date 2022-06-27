package com.energee3.stage.companyVehicles.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface CustomCrudRepository extends CrudRepository<Object, Integer> {
	
	default public List<Map<String, Object>> getHistory(String licensePlate){
		List<Map<String, Object>> myMaps = new ArrayList<Map<String, Object>>();
		List<Object[]> objects = getProcedureHistory(licensePlate); //"WGHBGHR"
		
		for (Object[] myObj : objects) {
			Map<String, Object> myMap = new HashMap<String, Object>();
			
			String vehicleId = (String) myObj[0];
			myMap.put("vehicle_id", vehicleId);
			
			Integer employeeId = (Integer) myObj[1];
			myMap.put("employee_id", employeeId);
			
			String firstName = (String) myObj[2];
			myMap.put("first_name", firstName);
			
			String lastName = (String) myObj[3];
			myMap.put("last_name", lastName);
			
			Timestamp startDate = (Timestamp) myObj[4];
			myMap.put("start_date", startDate);
			
			Timestamp endDate = (Timestamp) myObj[5];
			myMap.put("end_date", endDate);
			
			BigDecimal km = (BigDecimal) myObj[6];
			myMap.put("km", km);
			
			String note = (String) myObj[7];
			myMap.put("note", note);
			
			myMaps.add(myMap);
		}
		return myMaps;
	}
	
	@Procedure("history")
	public List<Object[]> getProcedureHistory(String plate);
	
}
