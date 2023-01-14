package com.example.orderservice.controller;

import com.example.orderservice.pojo.Car;
import com.example.orderservice.service.CarService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private RabbitTemplate rabbitTemplate;



    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return  ResponseEntity.ok(cars);
    }

    @PutMapping("/updateQuantity/{carId}")
    public boolean updateQuantityCar(@PathVariable("carId") String carId) throws IOException {
        List<Car> cars = carService.getAllCars();
        for (Car car : cars) {
            if (car.get_id().equals(carId)) {
                carService.updateQuantityCar(new Car(car.get_id(), car.getType(), car.getBrand(), car.getModel(),
                        car.getNumOfSeat(), car.getPrice(), car.getQuantity() - 1, car.getImage()));
                rabbitTemplate.convertSendAndReceive("OrderDirectExchange", "update",carId );
                return true;
            }

        }
        return true;
    }

}
