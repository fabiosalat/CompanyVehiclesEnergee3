package com.energee3.stage.companyVehicles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energee3.stage.companyVehicles.model.Manufacturer;
import com.energee3.stage.companyVehicles.model.Model;
import com.energee3.stage.companyVehicles.model.Vehicles;
import com.energee3.stage.companyVehicles.repository.ManufacturerRepository;
import com.energee3.stage.companyVehicles.repository.ModelRepository;
import com.energee3.stage.companyVehicles.repository.VehiclesRepository;


@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {
	
	@Autowired
	private VehiclesRepository vehicles;
	@Autowired
	private ManufacturerRepository manufacturer;

	@Autowired
	private ModelRepository model;
	
	
	@GetMapping("/manufacturer")
	public Iterable<Manufacturer> getAllManufacturers(){
		return manufacturer.findAll();
	}
	
	@GetMapping("/models")
	public Iterable<Model> getAllModels(){
		return model.findAll();
	}
	
	@GetMapping("/findAll")
	public Iterable<Vehicles> getAllVehicles(){
		return vehicles.findAll();
	}
	
	@GetMapping("/modelByManufacturer/{manufacturer}")
	public List<Model> getModelsByManufacturer(@PathVariable("manufacturer") String manufacturerName){
		Manufacturer manufacturerRecord = new Manufacturer();
		manufacturerRecord = manufacturer.findManufacturerByName(manufacturerName);
		Integer id = manufacturerRecord.getId();
		Manufacturer manufacturerId = new Manufacturer();
		manufacturerId.setId(id);
		return model.findModelsByManufacturerId(manufacturerId);
	}

	
	@GetMapping("/vehicleById/{license_plate}")
	public Vehicles getVehicleByLicensePlate(@PathVariable("license_plate") String licensePlate) {
		return vehicles.findById(licensePlate).get();
	}
	
	@GetMapping("/byFilter")
	public List<Vehicles> getVehiclesByFilter(@RequestBody Vehicles searchVehicle){
			return vehicles.findAll(Example.of(new Vehicles(searchVehicle.getId(), searchVehicle.getFuel(), 
					searchVehicle.getModelId(), searchVehicle.getActive())));
	}
	
	@PutMapping("update")
	public Vehicles updateActiveVehicle(@RequestBody Vehicles vehiclesData, @PathVariable String id) {
		Vehicles vehicle = vehicles.findById(id).get();
		vehicle.setActive(vehiclesData.getActive());
		return vehicles.save(vehicle);
	}
	
	@PostMapping("/newManufacturer")
	public Manufacturer insertNewManufacturer(@RequestBody Manufacturer newManufacturer) {
		return manufacturer.save(newManufacturer);
		
	}
	
	@PostMapping("/newModel")
	public Model insertNewModel(@Valid @RequestBody Model newModel) {
		return model.save(newModel);
		
	}
	
	@PostMapping("/new")
	public Vehicles insertNewVehicle(@Valid @RequestBody Vehicles newVehicles) {
		return vehicles.save(newVehicles);
	}
}
