package com.airbnb.airbnb.service;

import com.airbnb.airbnb.entity.Property;

import java.util.List;

public interface ProperityService {
    public Property createProperty(Property property);
    public  Property updateProperty(String hostId,Property property);
    public List<Property>getProperty();
}
