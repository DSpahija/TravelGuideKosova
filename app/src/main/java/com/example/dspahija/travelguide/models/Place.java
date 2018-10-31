package com.example.dspahija.travelguide.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Place{

    @SerializedName("PlaceId")
    @Expose
    private Integer placeId;

    @SerializedName("Category")
    @Expose
    private String category;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("City")
    @Expose
    private String city;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("Picture")
    @Expose
    private String picture;

    private List<Place> places;


    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
