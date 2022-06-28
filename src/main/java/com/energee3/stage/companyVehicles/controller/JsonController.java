package com.energee3.stage.companyVehicles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JsonController {
	
	@GetMapping("/kmNote")
	public String kmNote() {
		return "JSON EXAMPLE:\n" 
				+ "{\r\n"
				+ "    \"bookingId\": {\r\n"
				+ "        \"id\": 1\r\n"
				+ "    },\r\n"
				+ "    \"startDate\": \"2022-06-10T08:00:00.153+00:00\",\r\n"
				+ "    \"endDate\": \"2022-06-10T11:00:00.153+00:00\",\r\n"
				+ "    \"km\": 32.1,\r\n"
				+ "    \"note\": \"\"\r\n"
				+ "}";
	}
	
	@GetMapping("/newBooking")
	public String newBooking() {
		return "JSON EXAMPLE:\n" 
				+ "{\r\n"
				+ "    \"employeeId\": {\r\n"
				+ "        \"id\": 1\r\n"
				+ "    },\r\n"
				+ "    \"vehicleId\": {\r\n"
				+ "        \"id\": \"WGHBGHR\"\r\n"
				+ "    },\r\n"
				+ "    \"startDate\": \"2022-06-29T08:00:00.153+00:00\",\r\n"
				+ "    \"endDate\": \"2022-07-01T08:00:00.153+00:00\"\r\n"
				+ "}";
	}

	@GetMapping("/newEmployee")
	public String newEmployee() {
		return 	"JSON EXAMPLE:\n" 
				+ "{\r\n"
				+ "    \"firstName\": \"Fabio\",\r\n"
				+ "    \"lastName\": \"Salatino\",\r\n"
				+ "    \"sex\": \"M\",\r\n"
				+ "    \"phoneNumber\": \"3801254489\",\r\n"
				+ "    \"email\": \"fabio.salatino@energee3.com\",\r\n"
				+ "    \"taxCode\": \"AJEJ33EBRAZO00RF\"\r\n"
				+ "}";
	}

	@GetMapping("/newVehicle")
	public String newVehicle() {
		return 	"JSON EXAMPLE:\n" 
				+ "{\r\n"
				+ "    \"id\": \"EY091AE\",\r\n"
				+ "    \"fuel\": \"Hybrid\",\r\n"
				+ "    \"modelId\": {\r\n"
				+ "        \"id\": 3\r\n"
				+ "    }\r\n"
				+ "}";
	}
	
	@GetMapping("/newModel")
	public String newModel() {
		return 	"JSON EXAMPLE:\n" 
				+ "{\r\n"
				+ "    \"name\": \"Classe B\",\r\n"
				+ "    \"yearProd\": 2020,\r\n"
				+ "    \"manufacturerId\": {\r\n"
				+ "        \"id\": 4\r\n"
				+ "    }\r\n"
				+ "}";
	}

}
