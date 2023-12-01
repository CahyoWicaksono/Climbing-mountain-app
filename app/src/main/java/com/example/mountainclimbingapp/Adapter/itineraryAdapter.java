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

import com.example.mountainclimbingapp.Model.ItineraryModel;
import com.example.mountainclimbingapp.R;

import java.util.ArrayList;


public class itineraryAdapter extends RecyclerView.Adapter<itineraryAdapter.ViewHolder>{
    int lastpos = -1;
    private ArrayList<ItineraryModel> itineraryModelArrayList;
    private Context context;
    private ViewDataClickInterface viewDataClickInterface;


    public itineraryAdapter(ArrayList<ItineraryModel> itineraryModelArrayList, Context context,
                            ViewDataClickInterface viewDataClickInterface) {
        this.itineraryModelArrayList = itineraryModelArrayList;
        this.context = context;
        this.viewDataClickInterface = viewDataClickInterface;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_initiary,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder assetholder, int position) {
        ItineraryModel itineraryModel = itineraryModelArrayList.get(position);
        assetholder.time.setText(itineraryModel.getDate());
        assetholder.location.setText(itineraryModel.getLocation());

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
        return itineraryModelArrayList.size();
    }
    public interface ViewDataClickInterface {
        void onViewDataClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView time, location,supplier;

        public ViewHolder(@NonNull View itemView) {super(itemView);
            time =  itemView.findViewById(R.id.TV_initiary1);
            location =itemView.findViewById(R.id.TV_initiary2);

        }
    }

}
