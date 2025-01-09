package com.airbnb.airbnb.repository;

import com.airbnb.airbnb.entity.Property;
import com.airbnb.airbnb.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProperityRepository extends MongoRepository<Property, String> {
   // List<Property> findByHost_Id(String hostId);
    Optional<Property> findByHost_Id(String hostId);

}
