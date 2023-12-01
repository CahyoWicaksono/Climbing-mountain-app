package com.example.mountainclimbingapp.Model;

public class LocationData {
    String placeNameLocation;
    String priceLocation;
    Integer imageUrlLocation;

    public Integer getImageUrlLocation() {
        return imageUrlLocation;
    }

    public void setImageUrlLocation(Integer imageUrlLocation) {
        this.imageUrlLocation = imageUrlLocation;
    }

    public LocationData(String placeNameLocation, String priceLocation, Integer imageUrlLocation) {

        this.placeNameLocation = placeNameLocation;
        this.priceLocation = priceLocation;
        this.imageUrlLocation = imageUrlLocation;
    }

    public String getPlaceNameLocation() {
        return placeNameLocation;
    }

    public void setPlaceNameLocation(String placeNameLocation) {
        this.placeNameLocation = placeNameLocation;
    }

    public String getPriceLocation() {
        return priceLocation;
    }

    public void setPriceLocation(String priceLocation) {
        this.priceLocation = priceLocation;
    }
}

