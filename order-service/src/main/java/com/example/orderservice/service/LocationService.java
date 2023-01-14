package com.example.orderservice.service;

import com.example.orderservice.pojo.Location;
import com.example.orderservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }
    public List<Location> getAllLocations(){
        try{
            List<Location> locations = locationRepository.findAll();
            return locations;
        } catch (Exception e){
            return null;
        }

    }

}
