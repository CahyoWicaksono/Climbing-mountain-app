package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;


public class ViewActivity extends AppCompatActivity {
    private ImageView imageViewDetail, backDetail, plan, view;
    private TextView text_title_detail, text_description_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_1);

        imageViewDetail = findViewById(R.id.imageDetail1);
        backDetail = findViewById(R.id.back_detail1);
        text_title_detail = findViewById(R.id.title_detail1);
        text_description_detail = findViewById(R.id.desc_detail1);
        plan = findViewById(R.id.button_plan);
        view = findViewById(R.id.View_other);

        text_title_detail.setText(getIntent().getExtras().getString("place name"));
        text_description_detail.setText(getIntent().getExtras().getString("description"));

        int imageView=getIntent().getIntExtra("image", 0);
        imageViewDetail.setImageResource(imageView);

        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailActivity.class));
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });



    }
}
