package com.example.mountainclimbingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mountainclimbingapp.Model.ShceduleModel;
import com.example.mountainclimbingapp.R;

import java.util.ArrayList;

public class ShceduleAdapter extends RecyclerView.Adapter<ShceduleAdapter.ViewHolder>{
    int lastpos = -1;
    private ArrayList<ShceduleModel> shceduleModelArrayList;
    private Context context;
    private ViewDataClickInterface viewDataClickInterface;


    public ShceduleAdapter(ArrayList<ShceduleModel> shceduleModelArrayList, Context context,
                           ViewDataClickInterface viewDataClickInterface) {
        this.shceduleModelArrayList = shceduleModelArrayList;
        this.context = context;
        this.viewDataClickInterface = viewDataClickInterface;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_schedule,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder assetholder, int position) {
        ShceduleModel shceduleModel = shceduleModelArrayList.get(position);
        assetholder.time.setText(shceduleModel.getDate());
        assetholder.location.setText(shceduleModel.getLocation());

        setAnimation(assetholder.itemView,position);
        assetholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDataClickInterface.onViewDataClick(position);
            }
        });
    }

    private void setAnimation(View itemView,int position){
        if (position > lastpos){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastpos = position;
        }

    }
    @Override
    public int getItemCount() {
        return shceduleModelArrayList.size();
    }
    public interface ViewDataClickInterface {
        void onViewDataClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView time, location,supplier;

        public ViewHolder(@NonNull View itemView) {super(itemView);
            time =  itemView.findViewById(R.id.Date_TV1);
            location =itemView.findViewById(R.id.location_TV2);

        }
    }

}
