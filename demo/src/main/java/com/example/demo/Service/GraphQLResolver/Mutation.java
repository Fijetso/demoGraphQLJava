package com.example.demo.Service.GraphQLResolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.Model.Vehicle;
import com.example.demo.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private VehicleService vehicleService;
    public Vehicle createVehicle(final String type, final String modelCode, final int brandId, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandId, launchDate);
    }
}
