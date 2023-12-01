package com.example.mountainclimbingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShceduleModel implements Parcelable {
    String location, date, tripID;

    ShceduleModel(){

    }
    public ShceduleModel(String location, String date, String tripID) {
        this.location = location;
        this.date = date;
        this.tripID = tripID;
    }

    protected ShceduleModel(Parcel in) {
        location = in.readString();
        date = in.readString();
        tripID = in.readString();

    }

    public static final Creator<ShceduleModel> CREATOR = new Creator<ShceduleModel>() {
        @Override
        public ShceduleModel createFromParcel(Parcel in) {return new ShceduleModel(in);
        }

        @Override
        public ShceduleModel[] newArray(int size) {return new ShceduleModel[size];
        }
    };
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTripID() {
        return tripID;
    }

    public void setTripID(String tripID) {
        this.tripID = tripID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(location);
        parcel.writeString(date);
        parcel.writeString(tripID);

    }
}
