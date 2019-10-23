package com.example.demo.Service.GraphQLResolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.Model.Vehicle;
import com.example.demo.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }
}