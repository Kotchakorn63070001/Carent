package com.example.orderservice.controller;

import com.example.orderservice.pojo.Location;
import com.example.orderservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @GetMapping("/getAllLocations")
    public ResponseEntity<?> getAllCars(){
        List<Location> cars = locationService.getAllLocations();
        return  ResponseEntity.ok(cars);
    }
}
