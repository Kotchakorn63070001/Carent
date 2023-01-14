package com.example.paymentservice.repository;

import com.example.paymentservice.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments(){
        try {
            List<Payment> payments = paymentRepository.findAll();
            return payments;
        } catch (Exception e){
            return null;
        }
    }

    public boolean addPayment(Payment payment){
        try {
            paymentRepository.save(payment);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Payment getPaymentById(String id){
        try {
            return paymentRepository.findByPaymentId(id);
        } catch (Exception e){
            return null;
        }
    }

    public boolean deletePayment(Payment payment){
        try {
            paymentRepository.delete(payment);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
