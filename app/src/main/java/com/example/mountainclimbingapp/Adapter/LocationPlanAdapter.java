package com.example.mountainclimbingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Model.LocationData;
import com.example.mountainclimbingapp.R;

import java.util.List;

public class LocationPlanAdapter extends RecyclerView.Adapter<LocationPlanAdapter.RecentsViewHolder> {
    Context context;
    List<LocationData> locationData;

    public LocationPlanAdapter(Context context, List<LocationData> locationData) {
        this.context = context;
        this.locationData = locationData;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_location, parent, false);
        // here we create a recyclerview row item layout file
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

        holder.placeName.setText(locationData.get(position).getPlaceNameLocation());
        holder.price.setText(locationData.get(position).getPriceLocation());
        holder.placeImage.setImageResource(locationData.get(position).getImageUrlLocation());

    }

    @Override
    public int getItemCount() {
        return locationData.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName,price;

        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image_location);
            placeName = itemView.findViewById(R.id.title_1);
            price = itemView.findViewById(R.id.cost_mount);

        }
    }
}
