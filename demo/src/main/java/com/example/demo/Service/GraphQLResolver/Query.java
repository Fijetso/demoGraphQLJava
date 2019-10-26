package com.example.demo.Service.GraphQLResolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.Model.Brand;
import com.example.demo.Model.BrandRepository;
import com.example.demo.Model.Vehicle;
import com.example.demo.Model.VehicleRepository;
import com.example.demo.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleService vehicleService;

	public List<Vehicle> getVehicles(final int count) {
		return this.vehicleService.getAllVehicles(count);
	}

	public Optional<Vehicle> getVehicle(final int id) {
		return this.vehicleService.getVehicle(id);
	}

	public Optional<Brand> getBrand(final int id) {
		Optional<Brand> foundBrand = this.brandRepository.findById(id);
		System.out.print(vehicleRepository.findByBrand(foundBrand.get()));
		return foundBrand;
	}
}