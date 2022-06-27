package com.dakual.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.dakual.springmongodb.model.User;

public interface UserRepository extends MongoRepository<User,String> {
   /*
    public User findByName(String  name);
    public List<User> findSurname(String surname);
    */
}
