package com.example.orderservice.repository;

import com.example.orderservice.pojo.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    @Query(value = "{type: '?0'}")
    public List<Car> findByType(String type);

    @Query(value = "{brand: '?0'}")
    public List<Car> findByBrand(String brand);

    @Query(value = "{model: '?0'}")
    public Car findByModel(String model);
}
