package com.example.demo.Service.GraphQLResolver.Resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.Model.Brand;
import com.example.demo.Model.BrandRepository;
import com.example.demo.Model.Vehicle;
import com.example.demo.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class VehicleResolver implements GraphQLResolver<Vehicle> {
	@Autowired
	private BrandRepository brandRepository;
	
    public Optional<Brand> getBrand(Vehicle vehicle) {
        return brandRepository.findById(vehicle.getBrand().getId());
    }
}