package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;


public class ViewGuideActivity extends AppCompatActivity {

    private ImageView backDetail, backround;
    private TextView title, descriprion, seeviers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_view);

        backDetail = findViewById(R.id.back_detail_guide);
        backround = findViewById(R.id.imageView_detail_guide);
        title = findViewById(R.id.place_name_detail_guide);
        descriprion = findViewById(R.id.desc_detail_guide);
        seeviers = findViewById(R.id.rating_count_guide);

        title.setText(getIntent().getExtras().getString("equipment"));
        descriprion.setText(getIntent().getExtras().getString("description"));
        descriprion.setText(getIntent().getExtras().getString("price"));

        int imageViewBackround=getIntent().getIntExtra("image", 0);
        backround.setImageResource(imageViewBackround);

        backDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewGuideActivity.this, HomeActivity.class));
            }
        });

    }
}
