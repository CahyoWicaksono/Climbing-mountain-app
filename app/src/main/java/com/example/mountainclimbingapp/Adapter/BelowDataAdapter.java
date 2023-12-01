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
import com.example.mountainclimbingapp.Model.BelowDataModel;
import com.example.mountainclimbingapp.R;

public class BelowDataAdapter extends RecyclerView.Adapter<BelowDataAdapter.View_Holder> {

    private BelowDataModel[] data_list_popular;

    public BelowDataAdapter(BelowDataModel[] data_list_populator){
        this.data_list_popular = data_list_populator;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View list_item = layoutInflater.inflate(R.layout.card_popular2, null);
        View_Holder view_holder = new View_Holder(list_item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        BelowDataModel belowDataModel = data_list_popular[position];
        holder.imageViewPopular1.setImageResource(belowDataModel.getImage());
        holder.titlePopular.setText(belowDataModel.getDescription());

        holder.main_popular_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewActivity.class);
                intent.putExtra("place name", belowDataModel.getPlaceName());
                intent.putExtra("description", belowDataModel.getDescription());
                intent.putExtra("price", belowDataModel.getPrice());
                intent.putExtra("image", belowDataModel.getImage());

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

            imageViewPopular1 = itemView.findViewById(R.id.place_image_popular2);
            titlePopular = itemView.findViewById(R.id.card_title_popular2);

            main_popular_2 = itemView.findViewById(R.id.cv_popular_2);
        }
    }
}
