package com.example.demo.Service.GraphQLResolver.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.Model.Brand;
import com.example.demo.Model.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public class BrandQuery implements GraphQLQueryResolver {
    @Autowired
    private BrandRepository brandRepository;
    public Optional<Brand> getBrand(final int id) {
        return this.brandRepository.findById(id);
    }
}