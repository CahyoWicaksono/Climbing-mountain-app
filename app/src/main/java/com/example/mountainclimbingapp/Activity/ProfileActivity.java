package com.example.mountainclimbingapp.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Adapter.ProfileDataAdapter;
import com.example.mountainclimbingapp.Model.ProfileModel;
import com.example.mountainclimbingapp.Model.WriteAccountDetailsModel;
import com.example.mountainclimbingapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private ImageView backProfile;
    private TextView name, email;
    private RecyclerView recyclerView;
    private FirebaseAuth auth;

    ProfileDataAdapter profileDataAdapter;
    String FullName,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);

        backProfile = findViewById(R.id.back_profile);
        name = findViewById(R.id.txt_name_profile);
        email = findViewById(R.id.txt_email_profile);

        auth                = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if (firebaseUser == null){
            Toast.makeText(ProfileActivity.this, "Something went wrong! User's details are not available at the moment",
                    Toast.LENGTH_SHORT).show();
        }else {
            checkIfEmailVerified(firebaseUser);
            showUserProfile(firebaseUser);
        }

        ProfileModel[] my_data_popular = new ProfileModel[]{
                new  ProfileModel("Switzerland", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        R.drawable.mb_mountain11 ,"4,7", "10-13-2021"),
                new  ProfileModel("Switzerland", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        R.drawable.mb_mountain10 ,"4,7", "10-13-2021"),
                new  ProfileModel("Switzerland", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        R.drawable.mb_mountain8 ,"4,7", "10-13-2021"),
                new  ProfileModel("Switzerland", "The mountains of Holland in Switzerland are 2.343 meters above sea level",
                        R.drawable.mb_mountain6 ,"4,7", "10-13-2021"),

        };
        recyclerView = findViewById(R.id.list_profile);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager1);
        ProfileDataAdapter profileDataAdapter = new ProfileDataAdapter(my_data_popular);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(profileDataAdapter);
    };
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

                    name.setText(FullName);
                    email.setText(Email);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

