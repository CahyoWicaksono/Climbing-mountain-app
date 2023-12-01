package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Adapter.GuideDataAdapter;
import com.example.mountainclimbingapp.Model.GuideDataModel;
import com.example.mountainclimbingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class GuideActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);


        bottomNavigationView = findViewById(R.id.botomNavigationView_guide);
        bottomNavigationView.setSelectedItemId(R.id.id_guide);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.id_transit:
                        startActivity(new Intent(getApplicationContext(), TransitActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.id_guide:
                        return true;
                    case R.id.id_goals:
                        startActivity(new Intent(getApplicationContext(), GoalsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });

        GuideDataModel[] my_data_popular = new GuideDataModel[]{
                new  GuideDataModel("Switzerland", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        "4.5" , R.drawable.equipment),
                new  GuideDataModel("Rute", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        "4.2" , R.drawable.rute),
                new  GuideDataModel("Medical", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        "4.5" , R.drawable.medical),
                new  GuideDataModel("Basics", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        "4.5" , R.drawable.basics),
                new  GuideDataModel("Tent", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        "4.5" , R.drawable.tent),
        };
        recyclerView = findViewById(R.id.list_guide);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager1);
        GuideDataAdapter guideDataAdapter = new GuideDataAdapter(my_data_popular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(guideDataAdapter);
    };

}
