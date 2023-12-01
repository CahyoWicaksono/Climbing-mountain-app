package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;


public class ViewprofileActivity extends AppCompatActivity {
    private ImageView imageViewDetail, backDetail, back;
    private TextView text_title_detail, text_description_detail, text_rating_detail, date;
    private Button button_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail_activity);

        imageViewDetail = findViewById(R.id.imageView_detail_profile);
        backDetail = findViewById(R.id.back_detail_profile);
        text_title_detail = findViewById(R.id.place_name_detail_profile);
        text_description_detail = findViewById(R.id.desc_detail_profile);
        text_rating_detail = findViewById(R.id.rating_count_profile);
        date = findViewById(R.id.date_profile_profile);


        text_title_detail.setText(getIntent().getExtras().getString("place name"));
        text_description_detail.setText(getIntent().getExtras().getString("description"));
        date.setText(getIntent().getExtras().getString("date"));
        text_rating_detail.setText(getIntent().getExtras().getString("rating"));

        int imageView=getIntent().getIntExtra("image", 0);
        imageViewDetail.setImageResource(imageView);

        back = findViewById(R.id.back_detail_profile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });


    }
}
