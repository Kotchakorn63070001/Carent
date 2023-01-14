package com.example.orderservice.service;

import com.example.orderservice.pojo.Car;
import com.example.orderservice.repository.CarRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @RabbitListener(queues = "UpdateQuantityCar")
    public boolean updateQuantityCar(Car car) throws IOException {
        try {
            carRepository.save(car);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
