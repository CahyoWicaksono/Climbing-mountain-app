package com.example.mountainclimbingapp.Model;

public class GuideDataModel {
    String equipmentName;
    String descriptionEquipment;
    String priceEquipment;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public GuideDataModel(String equipmentName, String descriptionEquipment, String priceEquipment, Integer imageUrl) {

        this.equipmentName = equipmentName;
        this.descriptionEquipment = descriptionEquipment;
        this.priceEquipment = priceEquipment;
        this.imageUrl = imageUrl;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getDescriptionEquipment() {
        return descriptionEquipment;
    }

    public void setDescriptionEquipment(String descriptionEquipment) {this.descriptionEquipment = descriptionEquipment;}

    public String getPriceEquipment() {
        return priceEquipment;
    }

    public void setPriceEquipment(String priceEquipment) {this.priceEquipment = priceEquipment;}


}

