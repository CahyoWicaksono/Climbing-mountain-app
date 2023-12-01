package com.example.mountainclimbingapp.Model;

public class BelowDataModel {

    private String placeName,description,  price;
    private int image;


    public BelowDataModel( String placeName,String description, int image, String price) {
        this.placeName = placeName;
        this.description = description;
        this.image = image;
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
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
