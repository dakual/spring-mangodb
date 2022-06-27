package com.dakual.springdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dakual.springdemo.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
   /*
    public User findByName(String  name);
    public List<User> findSurname(String surname);
    */
}
