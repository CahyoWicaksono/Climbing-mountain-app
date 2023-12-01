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

import com.example.mountainclimbingapp.Activity.ViewDetailActivity;
import com.example.mountainclimbingapp.Model.TopDataModel;
import com.example.mountainclimbingapp.R;


public class TopDataAdapter extends RecyclerView.Adapter<TopDataAdapter.View_Holder> {

    private TopDataModel[] data_list;

    public TopDataAdapter(TopDataModel[] data_list){
        this.data_list = data_list;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View list_item = layoutInflater.inflate(R.layout.card_popular1, null);
        View_Holder view_holder = new View_Holder(list_item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        TopDataModel topDataModel = data_list[position];
        holder.imageViewPopular1.setImageResource(topDataModel.getImage());
        holder.titlePopular.setText(topDataModel.getTitle());
        holder.pricePopular.setText(topDataModel.getPrice());

        holder.main_card_popular1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewDetailActivity.class);
                intent.putExtra("title", topDataModel.getTitle());
                intent.putExtra("description", topDataModel.getDescription());
                intent.putExtra("price", topDataModel.getPrice());
                intent.putExtra("image", topDataModel.getImage());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_list.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {

        ImageView imageViewPopular1;
        TextView titlePopular, pricePopular, desc;
        CardView main_card_popular1;
        public View_Holder(@NonNull View itemView) {
            super(itemView);

            imageViewPopular1 = itemView.findViewById(R.id.place_image);
            titlePopular = itemView.findViewById(R.id.card_title);
            pricePopular = itemView.findViewById(R.id.desc_popular);

            main_card_popular1 = itemView.findViewById(R.id.cv_popular_1);
        }
    }
}
