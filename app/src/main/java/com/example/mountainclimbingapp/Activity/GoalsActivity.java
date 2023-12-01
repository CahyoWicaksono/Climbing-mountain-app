package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Adapter.RecentsAdapter;
import com.example.mountainclimbingapp.Adapter.TopPlacesAdapter;
import com.example.mountainclimbingapp.Model.RecentsData;
import com.example.mountainclimbingapp.Model.TopPlacesData;
import com.example.mountainclimbingapp.Model.WriteAccountDetailsModel;
import com.example.mountainclimbingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GoalsActivity extends AppCompatActivity {
    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    LinearLayout ln_profile;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth auth;
    TextView textViewWelcome, textViewFullName, textViewEmail;
    String FullName,Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.archievement);

        textViewFullName = findViewById(R.id.my_name);
        textViewEmail = findViewById(R.id.my_email);

        auth                = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser == null){
            Toast.makeText(GoalsActivity.this, "Something went wrong! User's details are not available at the moment",
                    Toast.LENGTH_SHORT).show();
        }else {
            checkIfEmailVerified(firebaseUser);
            showUserProfile(firebaseUser);
        }

        ln_profile = findViewById(R.id.LN_profile);
        ln_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TeamActivity.class));
            }
        });


        bottomNavigationView = findViewById(R.id.botomNavigationView_goals);
        bottomNavigationView.setSelectedItemId(R.id.id_goals);
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
                        startActivity(new Intent(getApplicationContext(), GuideActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.id_goals:
                        return true;
                }

                return false;
            }
        });

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("AM Lake","India",R.drawable.mb_mountain10));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India",R.drawable.mb_mountain3));
        recentsDataList.add(new RecentsData("AM Lake","India",R.drawable.mb_mountain11));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India",R.drawable.mb_mountain9));

        setRecentRecycler(recentsDataList);
        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India",R.drawable.mountain_5));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India",R.drawable.mountain_2));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India",R.drawable.mountain_1));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India",R.drawable.mountain_7));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India",R.drawable.mountain_9));

        setTopPlacesRecycler(topPlacesDataList);
    }
    private  void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.list1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }
    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){
        topPlacesRecycler = findViewById(R.id.list2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
    }

    private void checkIfEmailVerified(FirebaseUser firebaseUser) {
        if (!firebaseUser.isEmailVerified()){
//            showAlertDialog();
        }
    }
    private void showUserProfile(FirebaseUser firebaseUser) {
        String UserId = firebaseUser.getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Register");
        databaseReference.child(UserId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                WriteAccountDetailsModel writeAccountDetailsModel = snapshot.getValue(WriteAccountDetailsModel.class);
                if (writeAccountDetailsModel != null){
                    FullName = firebaseUser.getDisplayName();
                    Email    = firebaseUser.getEmail();

                    textViewFullName.setText(FullName);
                    textViewEmail.setText(Email);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GoalsActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
