package com.airbnb.airbnb.Dto;

import com.airbnb.airbnb.entity.Users;

import java.util.List;

public class PropertyResponse {
    private String title;
    private String description;
    private double price;
    private String location;
    private List<String> images;
    private Users host;
    private List<ReviewResponse> reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Users getHost() {
        return host;
    }

    public void setHost(Users host) {
        this.host = host;
    }

    public List<ReviewResponse> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewResponse> reviews) {
        this.reviews = reviews;
    }
}
