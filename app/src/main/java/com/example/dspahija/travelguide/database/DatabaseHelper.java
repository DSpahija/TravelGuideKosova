package com.example.dspahija.travelguide.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TravelGuide.db";

    //Tables
    public static final String TABLE_CITY = "City";
    public static final String TABLE_FOOD = "Food";
    public static final String TABLE_ACCOMODATION = "Accomodation";
    public static final String TABLE_CULTURE = "Culture";
    public static final String TABLE_NIGHTLIFE = "Nightlife";
    public static final String TABLE_OUTDOOR= "Outdoor";

    //TABLE_CITY - Columns
    public static final String COLUMN_CITY_ID = "IDCity";
    public static final String COLUMN_CITY_NAME = "Name";

    //TABLE_FOOD - Columns
    public static final String COLUMN_FOOD_ID = "IDFood";
    public static final String COLUMN_FOOD_NAME = "Name";
    public static final String COLUMN_FOOD_CITY = COLUMN_CITY_NAME;
    public static final String COLUMN_FOOD_DESCRIPTION = "Description";
    public static final String COLUMN_FOOD_IMAGE = "Image";

    //TABLE_ACCOMODATION - Columns
    public static final String COLUMN_ACCOMODATION_ID = "IDAccomodation";
    public static final String COLUMN_ACCOMODATION_NAME = "Name";
    public static final String COLUMN_ACCOMODATION_CITY = COLUMN_CITY_NAME;
    public static final String COLUMN_ACCOMODATION_DESCRIPTION = "Description";
    public static final String COLUMN_ACCOMODATION_IMAGE = "Image";

    //TABLE_CULTURE - Columns
    public static final String COLUMN_CULTURE_ID = "IDCulture";
    public static final String COLUMN_CULTURE_NAME = "Name";
    public static final String COLUMN_CULTURE_CITY = COLUMN_CITY_NAME;
    public static final String COLUMN_CULTURE_DESCRIPTION = "Description";
    public static final String COLUMN_CULTURE_IMAGE = "Image";

    //TABLE_NIGHTLIFE - Columns
    public static final String COLUMN_NIGHTLIFE_ID = "IDNightLife";
    public static final String COLUMN_NIGHTLIFE_NAME = "Name";
    public static final String COLUMN_NIGHTLIFE_CITY = COLUMN_CITY_NAME;
    public static final String COLUMN_NIGHTLIFE_DESCRIPTION = "Description";
    public static final String COLUMN_NIGHTLIFE_IMAGE = "Image";

    //TABLE_OUTDOOR - Columns
    public static final String COLUMN_OUTDOOR_ID = "IDOutdoor";
    public static final String COLUMN_OUTDOOR_NAME = "Name";
    public static final String COLUMN_OUTDOOR_CITY = COLUMN_CITY_NAME;
    public static final String COLUMN_OUTDOOR_DESCRIPTION = "Description";
    public static final String COLUMN_OUTDOOR_IMAGE = "Image";


    private static final String SQL_CREATE_TABLE_CITY = "CREATE TABLE " + TABLE_CITY + "("
            + COLUMN_CITY_ID + "     INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CITY_NAME + " VARCHAR(10) "
            + ");";

    private static final String SQL_CREATE_TABLE_FOOD = "CREATE TABLE " + TABLE_FOOD + "("
            + COLUMN_FOOD_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FOOD_NAME + " VARCHAR(20), "
            + COLUMN_FOOD_CITY + " INT FOREIGN KEY REFERENCES City(IDCity), "
            + COLUMN_FOOD_DESCRIPTION + " VARCHAR(20), "
            + COLUMN_FOOD_IMAGE + " VARBINARYY(MAX) "
            + ");";

    private static final String SQL_CREATE_TABLE_ACCOMODATION = "CREATE TABLE " + TABLE_ACCOMODATION + "("
            + COLUMN_OUTDOOR_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_OUTDOOR_NAME + " VARCHAR(20, "
            + COLUMN_OUTDOOR_CITY + " INT FOREIGN KEY REFERENCES City(IDCity), "
            + COLUMN_OUTDOOR_DESCRIPTION + " VARCHAR(20), "
            + COLUMN_OUTDOOR_IMAGE + " VARBINARYY(MAX) "
            + ");";


    private static final String SQL_CREATE_TABLE_CULTURE = "CREATE TABLE " + TABLE_CULTURE + "("
            + COLUMN_CULTURE_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CULTURE_NAME + " VARCHAR(20), "
            + COLUMN_CULTURE_CITY + " INT FOREIGN KEY REFERENCES City(IDCity), "
            + COLUMN_CULTURE_DESCRIPTION + " VARCHAR(20), "
            + COLUMN_CULTURE_IMAGE + " VARBINARYY(MAX) "
            + ");";

    private static final String SQL_CREATE_TABLE_NIGHTLIFE = "CREATE TABLE " + TABLE_NIGHTLIFE + "("
            + COLUMN_NIGHTLIFE_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NIGHTLIFE_NAME + " VARCHAR(20), "
            + COLUMN_NIGHTLIFE_CITY + " INT FOREIGN KEY REFERENCES City(IDCity), "
            + COLUMN_NIGHTLIFE_DESCRIPTION + " VARCHAR(20), "
            + COLUMN_NIGHTLIFE_IMAGE + " VARBINARYY(MAX) "
            + ");";

    private static final String SQL_CREATE_TABLE_OUTDOOR = "CREATE TABLE " + TABLE_OUTDOOR + "("
            + COLUMN_OUTDOOR_ID + " INT PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_OUTDOOR_NAME + " VARCHAR(20), "
            + COLUMN_OUTDOOR_CITY + " INT FOREIGN KEY REFERENCES City(IDCity), "
            + COLUMN_OUTDOOR_DESCRIPTION + " VARCHAR(20), "
            + COLUMN_OUTDOOR_IMAGE + " VARBINARYY(MAX) "
            + ");";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CITY);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_FOOD);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_ACCOMODATION);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_CULTURE);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_NIGHTLIFE);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_OUTDOOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CITY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOMODATION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CULTURE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NIGHTLIFE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OUTDOOR);

        onCreate(sqLiteDatabase);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
}
