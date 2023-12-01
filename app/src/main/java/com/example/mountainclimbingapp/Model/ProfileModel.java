package com.example.mountainclimbingapp.Model;

public class ProfileModel {

    private String placeName,description,price,date;
    private int image;


    public ProfileModel(String placeName, String description, int image,String price, String date) {
        this.placeName = placeName;
        this.description = description;
        this.image = image;
        this.date = date;
        this.price = price;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
