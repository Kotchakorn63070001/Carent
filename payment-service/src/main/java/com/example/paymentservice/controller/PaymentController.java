package com.example.paymentservice.controller;

import com.example.paymentservice.pojo.Payment;
import com.example.paymentservice.repository.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getAllPayments")
    public ResponseEntity<?> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/addPayment/{orderId}")
    public ResponseEntity<?> addPayment(@PathVariable("orderId") String orderId,
                                        @RequestParam("cusName") String cusName,
                                        @RequestParam("email") String email,
                                        @RequestParam("datetime") String datetime,
                                        @RequestParam("totalPrice") int totalPrice){
        boolean status = paymentService.addPayment(new Payment(null, orderId, cusName, email, datetime, totalPrice));
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/delPayment/{paymentId}")
    public boolean deletePayment(@PathVariable("paymentId") String paymentId){
        Payment payment = paymentService.getPaymentById(paymentId);
        System.out.println(payment);
        boolean status = paymentService.deletePayment(payment);
        return status;
    }
}
