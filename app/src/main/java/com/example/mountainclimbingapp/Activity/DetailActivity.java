package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;


public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewMountain;
    private TextView text_title, text_description, text_price;
    private Button plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        text_title = findViewById(R.id.place_name_detail);
        text_description = findViewById(R.id.desc_detail);
        imageViewMountain = findViewById(R.id.imageView_detail);
        text_price = findViewById(R.id.cost);


        text_title.setText(getIntent().getExtras().getString("place name"));
        text_description.setText(getIntent().getExtras().getString("description"));
        text_price.setText(getIntent().getExtras().getString("price"));

        int imageView=getIntent().getIntExtra("image", 0);
        imageViewMountain.setImageResource(imageView);

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlanTravelActivity.class));
            }
        });

    }
}
