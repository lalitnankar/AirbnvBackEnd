package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Property;
import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.repository.ProperityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProperityServiceImp implements ProperityService {
    @Autowired
    ProperityRepository properityRepository;
    @Override
    public Property createProperty(Property property) {
        try{
            return properityRepository.save(property);
        }
        catch(Exception e){

            e.printStackTrace();
            return new Property ();
        }


    }
    public Property updateProperty(String hostId,Property property){
      //Optional<Property> update = properityRepository.findByHost_Id(hostId);
      try{
          Optional<Property> update = properityRepository.findByHost_Id(hostId);
           Property existProp = update.get();
           existProp.setDescription(property.getDescription());
           existProp.setPrice(property.getPrice());
           existProp.setTitle(property.getTitle());
           existProp.setLocation(property.getLocation());
           existProp.setReviews(property.getReviews());

          return properityRepository.save(existProp);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }

    @Override
    public List<Property> getProperty() {
          List<Property> getProperties = properityRepository.findAll();
        return getProperties;
    }
}
