package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mountainclimbingapp.Adapter.PlanningAdapter;
import com.example.mountainclimbingapp.Model.LocationModel;
import com.example.mountainclimbingapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PlanTravelActivity extends AppCompatActivity implements PlanningAdapter.ViewDataClickInterface{
    private ImageView back;
    private RecyclerView recyclerView;
    private Button addplanning;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<LocationModel> locationModelArrayList;
    private PlanningAdapter viewPlanningData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_activity);

        back = findViewById(R.id.back_planning);
        recyclerView = findViewById(R.id.list_planning);
        addplanning = findViewById(R.id.AddPlanning);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Planning");
        locationModelArrayList = new ArrayList<>();


        viewPlanningData = new PlanningAdapter(locationModelArrayList, this,  this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(viewPlanningData);

        addplanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanTravelActivity.this, AddPlanning.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanTravelActivity.this, HomeActivity.class));
            }
        });

        getAllLocation();


    }
    public void  getAllLocation(){
        locationModelArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                locationModelArrayList.add(snapshot.getValue(LocationModel.class));
                viewPlanningData.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                viewPlanningData.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                viewPlanningData.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                viewPlanningData.notifyDataSetChanged();
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
