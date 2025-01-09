package com.airbnb.airbnb.repository;

import com.airbnb.airbnb.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUserNameAndPassword(String username, String password);
}
