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

import com.example.mountainclimbingapp.Activity.ViewprofileActivity;
import com.example.mountainclimbingapp.Model.ProfileModel;
import com.example.mountainclimbingapp.R;


public class ProfileDataAdapter extends RecyclerView.Adapter<ProfileDataAdapter.View_Holder> {

    private ProfileModel[] data_list_popular;

    public ProfileDataAdapter(ProfileModel[] data_list_populator){
        this.data_list_popular = data_list_populator;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View list_item = layoutInflater.inflate(R.layout.profile_places_row_item, null);
        View_Holder view_holder = new View_Holder(list_item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        ProfileModel profileModel = data_list_popular[position];
        holder.imageViewPopular1.setImageResource(profileModel.getImage());
        holder.titlePopular.setText(profileModel.getPlaceName());
        holder.titlePopular.setText(profileModel.getDescription());

        holder.main_popular_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewprofileActivity.class);
                intent.putExtra("place name", profileModel.getPlaceName());
                intent.putExtra("description", profileModel.getDescription());
                intent.putExtra("date", profileModel.getDate());
                intent.putExtra("rating", profileModel.getPrice());
                intent.putExtra("image", profileModel.getImage());

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
            desc = itemView.findViewById(R.id.country_name_profile);

            main_popular_2 = itemView.findViewById(R.id.cv_main_profile);
        }
    }
}
