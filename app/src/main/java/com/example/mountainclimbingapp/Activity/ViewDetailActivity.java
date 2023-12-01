package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;

public class ViewDetailActivity extends AppCompatActivity {

    private ImageView imageViewMountain, back;
    private TextView text_title, text_description, text_price;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_detail_activity);

        text_title = findViewById(R.id.place_name_detail_top);
        text_description = findViewById(R.id.desc_detail_top);
        imageViewMountain = findViewById(R.id.imageView_detail_top);
        text_price = findViewById(R.id.cost_top);
        button = findViewById(R.id.plan_trip_top);


        text_title.setText(getIntent().getExtras().getString("title"));
        text_description.setText(getIntent().getExtras().getString("description"));
        text_price.setText(getIntent().getExtras().getString("price"));

        int imageView=getIntent().getIntExtra("image", 0);
        imageViewMountain.setImageResource(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlanTravelActivity.class));
            }
        });


    }
}
