package com.example.dspahija.travelguide.class_activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dspahija.travelguide.R;
import com.example.dspahija.travelguide.adapter.CustomListAdapter;

public class findPlaces extends Activity {

            ListView list;
            String[] itemname = {
                    "Prishtine",
                    "Mitrovice",
                    "Prizren",
                    "Peje",
                    "Gjakove",
                    "Gjilan",
                    "Ferizaj"
            };

            Integer[] imgid = {
                    R.drawable.map_prishtine,
                    R.drawable.map_mitrovica,
                    R.drawable.map_prizren,
                    R.drawable.map_peja,
                    R.drawable.map_gjakova,
                    R.drawable.map_gjilani,
                    R.drawable.map_ferizaj

            };

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_find_places);

                CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
                list = findViewById(R.id.listView_Places);
                list.setAdapter(adapter);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        if (i == 0) {
                            Intent activity = new Intent(view.getContext(), Prishtine.class);
                            startActivityForResult(activity, 0);
                        }
                        if (i == 1) {
                            Intent activity = new Intent(view.getContext(), Mitrovice.class);
                            startActivityForResult(activity, 0);
                        }
                        /*
                        else {
                            Toast.makeText(getApplicationContext(), "Ende pa perfunduar!", Toast.LENGTH_SHORT).show();
                        } */
                    }
                });
            }

    public void btn_Home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void btn_Map(View view) {
        Intent intent = new Intent(this, Map.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void btn_Weather(View view) {
    }
}

