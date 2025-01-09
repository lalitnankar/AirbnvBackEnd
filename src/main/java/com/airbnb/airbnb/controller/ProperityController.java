package com.airbnb.airbnb.controller;

import com.airbnb.airbnb.Dto.PropertyRequest;
import com.airbnb.airbnb.Dto.PropertyResponse;
import com.airbnb.airbnb.Dto.UserResponse;
import com.airbnb.airbnb.entity.Property;
import com.airbnb.airbnb.entity.Users;
import com.airbnb.airbnb.service.ProperityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/properity")
public class ProperityController {
    @Autowired
    ProperityServiceImp properityService;

  @PostMapping("/create")
  public ResponseEntity<PropertyResponse> createProperity(@RequestBody Property property) {
      PropertyResponse propertyResponse = new PropertyResponse();
      Property result = properityService.createProperty(property);
      propertyResponse.setDescription(result.getDescription());
      propertyResponse.setTitle(result.getTitle());
      propertyResponse.setImages(result.getImages());
      propertyResponse.setLocation(result.getLocation());
      propertyResponse.setPrice(result.getPrice());
      propertyResponse.setHost(result.getHost());


      return ResponseEntity.ok(propertyResponse);

  }
  @PutMapping("/update/{id}")
    public ResponseEntity<PropertyResponse> updateProperity( @PathVariable("id") String hostId,@RequestBody Property property){
      PropertyResponse propertyResponse = new PropertyResponse();
      Property result = properityService.updateProperty(hostId,property);
      propertyResponse.setDescription(result.getDescription());
      propertyResponse.setTitle(result.getTitle());
      propertyResponse.setImages(result.getImages());
      propertyResponse.setLocation(result.getLocation());
      propertyResponse.setPrice(result.getPrice());
      propertyResponse.setHost(result.getHost());


      return ResponseEntity.ok(propertyResponse);
  }
  @GetMapping("/viewProperty")
  public ResponseEntity<List<PropertyResponse>>  viewProperity() {
     // PropertyResponse propertyResponse = new PropertyResponse();
     List <Property> resultList = properityService.getProperty();
      List<PropertyResponse> propertyResponseList = new ArrayList<>();
     for( Property result : resultList){
         PropertyResponse propertyResponse = new PropertyResponse();
      propertyResponse.setDescription(result.getDescription());
      propertyResponse.setTitle(result.getTitle());
      propertyResponse.setImages(result.getImages());
      propertyResponse.setLocation(result.getLocation());
      propertyResponse.setPrice(result.getPrice());
      propertyResponse.setHost(result.getHost());
         propertyResponseList.add(propertyResponse);

     }



      return ResponseEntity.ok(propertyResponseList);

  }

}
