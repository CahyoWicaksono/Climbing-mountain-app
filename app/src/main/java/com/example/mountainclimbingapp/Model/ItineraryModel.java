package com.example.mountainclimbingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItineraryModel implements Parcelable {
    String location, date, itineraryID;

    ItineraryModel(){

    }
    public ItineraryModel(String location, String date, String itineraryID) {
        this.location = location;
        this.date = date;
        this.itineraryID = itineraryID;
    }

    protected ItineraryModel(Parcel in) {
        location = in.readString();
        date = in.readString();
        itineraryID = in.readString();

    }

    public static final Creator<ItineraryModel> CREATOR = new Creator<ItineraryModel>() {
        @Override
        public ItineraryModel createFromParcel(Parcel in) {return new ItineraryModel(in);
        }

        @Override
        public ItineraryModel[] newArray(int size) {return new ItineraryModel[size];
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

    public String getItineraryID() {
        return itineraryID;
    }

    public void setItineraryID(String tripID) {
        this.itineraryID = itineraryID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(location);
        parcel.writeString(date);
        parcel.writeString(itineraryID);

    }
}
