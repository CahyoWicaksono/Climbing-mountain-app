package com.example.mountainclimbingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationModel implements Parcelable {
    String location, date, tripID;

    LocationModel(){

    }
    public LocationModel(String location, String date, String tripID) {
        this.location = location;
        this.date = date;
        this.tripID = tripID;
    }

    protected LocationModel(Parcel in) {
        location = in.readString();
        date = in.readString();
        tripID = in.readString();

    }

    public static final Creator<LocationModel> CREATOR = new Creator<LocationModel>() {
        @Override
        public LocationModel createFromParcel(Parcel in) {return new LocationModel(in);
        }

        @Override
        public LocationModel[] newArray(int size) {return new LocationModel[size];
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
