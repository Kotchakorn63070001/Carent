package com.example.paymentservice.repository;

import com.example.paymentservice.pojo.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    @Query(value = "{_id: '?0'}")
    public Payment findByPaymentId(String paymentId);
}
