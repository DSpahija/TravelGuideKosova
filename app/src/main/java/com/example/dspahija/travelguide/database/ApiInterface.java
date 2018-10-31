package com.example.dspahija.travelguide.database;


import com.example.dspahija.travelguide.models.Place;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface{
    @GET("/api/places")
    Call<List<Place>> GetPlaces();
}