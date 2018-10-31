package com.example.dspahija.travelguide.database;

import android.content.ContentValues;


public class Restaurant_DB {

    private String Name;
    private String Description;
    private int CityId;
    private byte[] Image;

    public Restaurant_DB()
    {}
    public Restaurant_DB(String name, String description, int cityId, byte[] image) {
        Name = name;
        Description = description;
        CityId = cityId;
        Image = image;
    }

    public void createRestaurantPrishtine(String name, String description, int cityId, byte[] image)
    {
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUMN_FOOD_NAME, name);
        values.put(DatabaseHelper.COLUMN_FOOD_DESCRIPTION, description);
        values.put(DatabaseHelper.COLUMN_FOOD_IMAGE, image);
        values.put(DatabaseHelper.COLUMN_FOOD_CITY, cityId);
    }
}
