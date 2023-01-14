package com.example.orderservice.repository;

import com.example.orderservice.pojo.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Location,String> {
}
