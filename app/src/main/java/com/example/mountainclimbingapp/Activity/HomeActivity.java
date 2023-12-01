package com.example.mountainclimbingapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mountainclimbingapp.Adapter.BelowDataAdapter;
import com.example.mountainclimbingapp.Adapter.TopDataAdapter;
import com.example.mountainclimbingapp.Model.BelowDataModel;
import com.example.mountainclimbingapp.Model.TopDataModel;
import com.example.mountainclimbingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    RecyclerView belowRecycler, topPlacesRecycler;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);


        bottomNavigationView = findViewById(R.id.botomNavigationView_home);
        bottomNavigationView.setSelectedItemId(R.id.id_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_home:
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
                        startActivity(new Intent(getApplicationContext(), GoalsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
        TopDataModel[] my_data = new TopDataModel[]{
                new TopDataModel("Switzerland", "The Pietersberg is not the highest point in Holland but it is our favorite Dutch mountain. The mountain is part of an Altiplano of marlstone. The ambivalent relationship of the Dutch with mountains is well demonstrated as we approach the Sint- Pietersberg.",
                        R.drawable.mountain_1, "from $822"),
                new TopDataModel("USA", "Temperatures in Lake Placid throughout the winter season average about 26-30° F, although they are usually colder in January and February. Snow often begins as early as October and will stick around until the end of April.",
                        R.drawable.mountain_2, "from $782"),
                new TopDataModel("Norway", "Svalbard, also known as Spitsbergen or Spitzbergen, is a Norwegian archipelago in the Arctic Ocean. North of mainland Europe, it lies about midway between the northern coast of Norway and the North Pole.",
                        R.drawable.mountain_3, "from $622"),
                new TopDataModel("Greenland", "Greenland is a North American autonomous territory of the Kingdom of Denmark. It is the largest country within the Kingdom and one of three countries which form the Kingdom, the others being Denmark proper and the Faroe Islands; the citizens of all three countries are citizens of Denmark.",
                        R.drawable.mountain_4, "from $802"),
                new TopDataModel("Canada", "Mount Logan is the highest mountain in Canada and the second-highest peak in North America after Denali. The mountain was named after Sir William Edmond Logan, a Canadian geologist and founder of the Geological Survey of Canada.",
                        R.drawable.mountain_5, "from $962"),
                new TopDataModel("Spain", "Monte Rosa is a mountain massif in the eastern part of the Pennine Alps, on the border between Italy (Piedmont and Aosta Valley) and Switzerland (Valais). The highest peak of the massif, amongst several peaks of over 4.000 m, is the Dufourspitze (4.634 m).",
                        R.drawable.mountain_6, "from $984"),
                new TopDataModel("Norway", "The road (Fylkesvei 55) is totally paved. It's 110km (70mi) long, running from Sogndalsfjøra (in Vestland county) to Lom (in Innlandet county). Inaugurated on 16th July 1938, the road is a little bit narrow at times but mostly fine. This is a windy mountain road with a few white-knuckle hairpin turns.",
                        R.drawable.mountain_7, "from $822"),
                new TopDataModel("Turkiye", "Mount Erciyes, also known as Argaeus, its etymon, is an inactive volcano in Kayseri Province, Turkey. It is a large stratovolcano surrounded by many monogenetic vents and lava domes, and one maar. The bulk of the volcano is formed by lava flows of andesitic and dacitic composition.",
                        R.drawable.mountain_8, "from $722"),
                new TopDataModel("New Zealand", "Aoraki / Mount Cook is the highest mountain in New Zealand. Its height, as of 2014 , is listed as 3,724 metres (12,218 feet). It sits in the Southern Alps, the mountain range that runs the length of the South Island.",
                        R.drawable.mountain_9, "from $722"),

        };
        topPlacesRecycler = findViewById(R.id.list_tour);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        TopDataAdapter topDataAdapter = new TopDataAdapter(my_data);
        topPlacesRecycler.setLayoutManager(new LinearLayoutManager(this));
        topPlacesRecycler.setAdapter(topDataAdapter);

        BelowDataModel[] my_data_popular = new BelowDataModel[]{
                new  BelowDataModel("Switzerland", "Monte Rosa, is the highest mountain in Switzerland and it lies right on the Italian border close to Zermatt and the Matterhorn. ",
                        R.drawable.mb_mountain2, "from $822"),
                    new  BelowDataModel("Poland", "The Beskids are approximately 600 km (370 mi) in length and 50–70 km (31–43 mi) in width. They stand mainly along the southern border of Lesser Poland with northern Slovakia, stretching to the Moravia and Czech Silesia regions of the eastern Czech Republic and to Carpathian Ruthenia in western Ukraine.",
                        R.drawable.mb_mountain3, "from $822"),
                new  BelowDataModel("United Kingdom", "Scafell Pike is one of a horseshoe of high fells, open to the south, surrounding the head of Eskdale, Cumbria. It stands on the western side of the cirque, with Scafell to the south and Great End to the north. ",
                        R.drawable.mb_mountain4, "from $822"),
                new  BelowDataModel("Srilanka", "Little Adams Peak is located in the small mountain town of Ella, right in the heart of Sri Lanka. If you plan on hiking Little Adams Peak, Sri Lanka, you’ll need to base yourself in the town of Ella for at least one night. This will enable you to have an early morning start so that you can reach the peak in time for sunrise.",
                        R.drawable.mb_mountain5, "from $822"),
                new  BelowDataModel("USA", "The Sierra Nevada is a mountain range in the Western United States, between the Central Valley of California and the Great Basin. The vast majority of the range lies in the state of California, although the Carson Range spur lies primarily in Nevada.",
                        R.drawable.mb_mountain6, "from $822"),
                new  BelowDataModel("Denmark", "Vágar is one of the 18 islands in the archipelago of the Faroe Islands and the most westerly of the large islands. With a size of 178 square kilometres, it ranks third in size, behind Streymoy and Eysturoy.",
                        R.drawable.mb_mountain7, "from $822"),
                new  BelowDataModel("France", "Mont Blanc is the most prominent mountain in France and rises to 4,808 meters, making it the highest mountain in the Alps. By ranking according to topographical prominence, it is the 11th highest peak in the world.",
                        R.drawable.mb_mountain8, "from $822"),
                new  BelowDataModel("Switzerland", "The Matterhorn is a mountain of the Alps, straddling the main watershed and border between Italy and Switzerland. It is a large, near-symmetric pyramidal peak in the extended Monte Rosa area of the Pennine Alps, whose summit is 4,478 metres high, making it one of the highest summits in the Alps and Europe. ",
                        R.drawable.mb_mountain9, "from $822"),
                new  BelowDataModel("Finland", "Halti is a fell at the border between Norway and Finland. The peak of the fell, called Ráisduattarháldi, is in Norway, on the border between the municipalities of Nordreisa and Gáivuotna–Kåfjord.",
                        R.drawable.mb_mountain10, "from $822"),
                new  BelowDataModel("Finland", "Ridnitšohkka is the second-highest point in Finland, though it is the highest mountain with its peak within Finland. The eastern face is steep while the western side is mild. ",
                        R.drawable.mb_mountain11, "from $822"),

        };
        belowRecycler = findViewById(R.id.list2);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        belowRecycler.setLayoutManager(layoutManager1);
        BelowDataAdapter belowDataAdapter = new BelowDataAdapter(my_data_popular);
        belowRecycler.setLayoutManager(new LinearLayoutManager(this));
        belowRecycler.setAdapter(belowDataAdapter);
    };

}
