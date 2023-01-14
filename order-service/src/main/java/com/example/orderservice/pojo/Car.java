package com.example.orderservice.pojo;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Car")
public class Car {
    @Id
    private String _id;
    private String type;
    private String brand;
    private String model;
    private int numOfSeat;
    private int price;
    private int quantity;
    private Binary image;

    public Car() {
    }

    public Car(String _id, String type, String brand, String model, int numOfSeat, int price, int quantity, Binary image) {
        this._id = _id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.numOfSeat = numOfSeat;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfSeat() {
        return numOfSeat;
    }

    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}