package com.sop.chapter10.authservice.repo;

import com.sop.chapter10.authservice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<User, String> {
    @Query(value = "{email:'?0'}")
    public User findUser(String email);


}
