package com.example.carservice6.controller;

import com.example.carservice6.pojo.Car;
import com.example.carservice6.repository.CarService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return  ResponseEntity.ok(cars);
    }

    @GetMapping("/getCarByType/{type}")
    public List<Car> getCarByType(@PathVariable("type") String type){
        List<Car> cars = carService.getCarByType(type);
        return cars;
    }

    @GetMapping("/getCarByBrand/{brand}")
    public List<Car> getCarByBrand(@PathVariable("brand") String brand){
        List<Car> cars = carService.getCarByBrand(brand);
        return cars;
    }

    @PostMapping("/addCar")
    public ResponseEntity<?> addCar(@RequestParam("type") String type,
                            @RequestParam("brand") String brand,
                            @RequestParam("model") String model,
                            @RequestParam("numOfSeat") int numOfSeat,
                            @RequestParam("price") int price,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("image") MultipartFile image) throws IOException{
        boolean status = carService.addCar(new Car(null, type, brand, model, numOfSeat, price, quantity, new Binary(BsonBinarySubType.BINARY, image.getBytes())));
        return ResponseEntity.ok(status);
    }

    @PutMapping("/updateCar/{id}")
    public boolean updateCar(@PathVariable("id") String id,
                                       @RequestParam("type") String type,
                                       @RequestParam("brand") String brand,
                                       @RequestParam("model") String model,
                                       @RequestParam("numOfSeat") int numOfSeat,
                                       @RequestParam("price") int price,
                                       @RequestParam("quantity") int quantity,
                                       @RequestParam("image") MultipartFile image) throws IOException{
        Car car = carService.getCarById(id);
        if (car != null){
            carService.updateCar(new Car(car.get_id(), type, brand, model, numOfSeat, price, quantity, new Binary(BsonBinarySubType.BINARY, image.getBytes())));
            return true;
        } else {
            return false;
        }

    }



    // delete car by model
    @DeleteMapping("/delCar/{model}")
    public boolean deleteCar(@PathVariable("model") String model){
        Car car = carService.getCarByModel(model);
        System.out.println(car);
        boolean status = carService.deleteCar(car);
        return status;
    }

}
