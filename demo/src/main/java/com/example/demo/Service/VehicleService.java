package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Brand;
import com.example.demo.Model.BrandRepository;
import com.example.demo.Model.Vehicle;
import com.example.demo.Model.VehicleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository ;
    private final BrandRepository brandRepository;
    public VehicleService(final VehicleRepository vehicleRepository, final BrandRepository brandRepository) {
        this.vehicleRepository = vehicleRepository ;
        this.brandRepository = brandRepository;
    }
    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final int brand, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        Optional<Brand> getBrand = brandRepository.findById(brand);
        getBrand.ifPresent(result -> vehicle.setBrand(result));
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        Vehicle newVehicle = this.vehicleRepository.save(vehicle);
        return newVehicle;
    }
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }
}