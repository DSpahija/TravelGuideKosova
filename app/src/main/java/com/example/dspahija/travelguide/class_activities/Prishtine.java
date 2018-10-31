package com.example.dspahija.travelguide.class_activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dspahija.travelguide.R;
import com.example.dspahija.travelguide.adapter.CustomListAdpter_CategoriesPlaces;
import com.example.dspahija.travelguide.database.ApiInterface;
import com.example.dspahija.travelguide.models.Place;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prishtine extends AppCompatActivity {

    Spinner spinner;
    ListView listPlaces;
    String categories[] = {"Food", "Accomodation", "Culture", "Nightlife", "Outdoor"};

    ArrayAdapter<String> adapterSpinner;
    ArrayAdapter adapterPlaceCategories;

    ApiInterface apiInterface;
    List<Place> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prishtine);


        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://kosovatravelguide.somee.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listPlaces = findViewById(R.id.listView_Places);

        apiInterface = retrofit.create(ApiInterface.class);
        foodList = new ArrayList<>();
        accomodationList = new ArrayList<>();
        cultureList = new ArrayList<>();
        nightlifeList = new ArrayList<>();
        outdoorList = new ArrayList<>();


        spinner = findViewById(R.id.spinner);
        adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinner.setAdapter(adapterSpinner);
        loadPlaces();



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: {
                        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, foodList);
                        listPlaces.setAdapter(adapterPlaceCategories);
                        break;
                    }
                    case 1: {
                        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, accomodationList);
                        listPlaces.setAdapter(adapterPlaceCategories);
                        break;
                    }
                    case 2: {
                        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, cultureList);
                        listPlaces.setAdapter(adapterPlaceCategories);
                        break;
                    }
                    case 3: {
                        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, nightlifeList);
                        listPlaces.setAdapter(adapterPlaceCategories);
                        break;
                    }
                    case 4: {
                        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, outdoorList);
                        listPlaces.setAdapter(adapterPlaceCategories);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ItemClickShowDialog();
    }


    List<Place> foodList, accomodationList, cultureList, nightlifeList, outdoorList;

    public void showList(List<Place> places){
        if (places!=null)
        {
            CategoryLists(places);
        }
    }

    public void loadPlaces(){
        Call<List<Place>> call = apiInterface.GetPlaces();

        call.enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                placeList = response.body();
                showList(placeList);
            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                Toast.makeText(Prishtine.this,"Fail to load Places!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void CategoryLists(List<Place> places){
        for (Place place:places)
        {
            if(place.getCity().equals("Prishtine")) {
                switch (place.getCategory()) {

                    case "Food": {
                        foodList.add(place);
                        break;
                    }
                    case "Accomodation": {
                        accomodationList.add(place);
                        break;
                    }
                    case "NightLife": {
                        nightlifeList.add(place);
                        break;
                    }
                    case "Culture": {
                        cultureList.add(place);
                        break;
                    }
                    case "Outdoor": {
                        outdoorList.add(place);
                        break;
                    }
                }
            }
        }
        adapterPlaceCategories = new CustomListAdpter_CategoriesPlaces(Prishtine.this, foodList);
        listPlaces.setAdapter(adapterPlaceCategories);
    }

    public void ItemClickShowDialog()
    {
        listPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place=placeList.get(position);


                AlertDialog.Builder builder=new AlertDialog.Builder(Prishtine.this);
                View dialogView=getLayoutInflater().inflate(R.layout.custom_placedetails_dialog,null);
                ImageView imageViewPlace=(ImageView)dialogView.findViewById(R.id.imageViewPlace);
                TextView tvName=(TextView) dialogView.findViewById(R.id.tvName);
                TextView tvDescription=(TextView)dialogView.findViewById(R.id.tvDescription);
                TextView tvCategory=(TextView)dialogView.findViewById(R.id.tvCategory);
                TextView tvCity=(TextView)dialogView.findViewById(R.id.tvCity);

                if (place.getPicture()=="" || place.getPicture()==null)
                {
                    Picasso.with(dialogView.getContext()).load(R.drawable.imagenotfound).into(imageViewPlace);
                }
                else
                {
                    Picasso.with(dialogView.getContext()).load(Uri.parse(place.getPicture())).error(R.drawable.imagenotfound).into(imageViewPlace);
                }

                tvName.setText("Name: "+place.getName());
                tvDescription.setText("Description: "+place.getDescription());
                tvCategory.setText("Category: "+place.getCategory());
                tvCity.setText("City: "+place.getCity());

                builder.setView(dialogView);
                AlertDialog dialog=builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
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

    public void btn_Places(View view) {
        Intent intent = new Intent(this, findPlaces.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
