package com.example.demo.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	List<Vehicle> findByBrand(Brand brand);
}
