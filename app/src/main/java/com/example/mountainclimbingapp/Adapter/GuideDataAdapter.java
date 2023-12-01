package com.example.mountainclimbingapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Activity.ViewActivity;
import com.example.mountainclimbingapp.Model.GuideDataModel;
import com.example.mountainclimbingapp.R;

public class GuideDataAdapter extends RecyclerView.Adapter<GuideDataAdapter.View_Holder> {

    private GuideDataModel[] data_list_popular;

    public GuideDataAdapter(GuideDataModel[] data_list_populator){
        this.data_list_popular = data_list_populator;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View list_item = layoutInflater.inflate(R.layout.guide_places_row_item, null);
        View_Holder view_holder = new View_Holder(list_item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        GuideDataModel guideDataModel = data_list_popular[position];
        holder.imageViewPopular1.setImageResource(guideDataModel.getImageUrl());
        holder.titlePopular.setText(guideDataModel.getDescriptionEquipment());

        holder.main_popular_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewActivity.class);
                intent.putExtra("equipment", guideDataModel.getEquipmentName());
                intent.putExtra("description", guideDataModel.getDescriptionEquipment());
                intent.putExtra("price", guideDataModel.getPriceEquipment());
                intent.putExtra("image", guideDataModel.getImageUrl());

                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data_list_popular.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {

        ImageView imageViewPopular1;
        TextView titlePopular, desc;
        CardView main_popular_2;
        public View_Holder(@NonNull View itemView) {
            super(itemView);

            imageViewPopular1 = itemView.findViewById(R.id.place_image_guide);
            titlePopular = itemView.findViewById(R.id.place_name_guide);
            desc = itemView.findViewById(R.id.desc_guide);


            main_popular_2 = itemView.findViewById(R.id.cv_guide);
        }
    }
}
