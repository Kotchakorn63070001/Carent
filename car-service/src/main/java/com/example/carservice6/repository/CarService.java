package com.example.carservice6.repository;

import com.example.carservice6.pojo.Car;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        try{
            List<Car> cars = carRepository.findAll();
            return cars;
        } catch (Exception e){
            return null;
        }

    }

    public List<Car> getCarByType(String type){
        try {
            return carRepository.findByType(type);
        } catch (Exception e){
            return null;
        }
    }

    public List<Car> getCarByBrand(String brand){
        try {
            return carRepository.findByBrand(brand);
        } catch (Exception e){
            return null;
        }
    }

    public boolean addCar(Car car) throws IOException{
        try {
            carRepository.save(car);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Car getCarByModel(String model){
        try {
            return carRepository.findByModel(model);
        } catch (Exception e){
            return null;
        }
    }

    public  Car getCarById(String id){
        try {
            return carRepository.findByCarId(id);
        } catch (Exception e){
            return null;
        }
    }

    public boolean deleteCar(Car car){
        try {
            carRepository.delete(car);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean updateCar(Car car) throws IOException{
        try {
            carRepository.save(car);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
