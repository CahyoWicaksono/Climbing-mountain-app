package com.example.mountainclimbingapp.Model;

public class WriteAccountDetailsModel {

    public String Dob, gender, mobile;

    public WriteAccountDetailsModel(){};

    public WriteAccountDetailsModel(String textDob, String textGender, String textMobile) {

        this.Dob = textDob;
        this.gender = textGender;
        this.mobile = textMobile;

    }


}
