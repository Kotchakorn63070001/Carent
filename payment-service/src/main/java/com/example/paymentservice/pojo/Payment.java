package com.example.paymentservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Payment")
public class Payment {
    @Id
    private String _id;
    private String orderId;
    private String cusName;
    private String email;
    private String datetime;
    private int totalPrice;

    public Payment() {
    }

    public Payment(String _id, String orderId, String cusName, String email, String datetime, int totalPrice) {
        this._id = _id;
        this.orderId = orderId;
        this.cusName = cusName;
        this.email = email;
        this.datetime = datetime;
        this.totalPrice = totalPrice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
