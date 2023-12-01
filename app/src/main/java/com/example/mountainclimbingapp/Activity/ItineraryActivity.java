package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Adapter.itineraryAdapter;
import com.example.mountainclimbingapp.Model.ItineraryModel;
import com.example.mountainclimbingapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ItineraryActivity extends AppCompatActivity implements itineraryAdapter.ViewDataClickInterface {
    private ImageView back;
    private RecyclerView recyclerView;
    private Button addplanning;
    private TextView next_page;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<ItineraryModel> itineraryModelArrayList;
    private itineraryAdapter itineraryadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itinerary_activity);

        back = findViewById(R.id.back_itiniary);
        recyclerView = findViewById(R.id.initiary_list);
        addplanning = findViewById(R.id.AddPlanningTrip);
        next_page = findViewById(R.id.Initiary_Next);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Itinerary");
        itineraryModelArrayList = new ArrayList<>();

        itineraryadapter = new itineraryAdapter(itineraryModelArrayList, this,  this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itineraryadapter);


        addplanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItineraryActivity.this, AddItinerary.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItineraryActivity.this, HomeActivity.class));
            }
        });

        getAllItinerary();



    }
    public void  getAllItinerary(){
        itineraryModelArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                itineraryModelArrayList.add(snapshot.getValue(ItineraryModel.class));
                itineraryadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                itineraryadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                itineraryadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                itineraryadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onViewDataClick(int position) {

    }
}
