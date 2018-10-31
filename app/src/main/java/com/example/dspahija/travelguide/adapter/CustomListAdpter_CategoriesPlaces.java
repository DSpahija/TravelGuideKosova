package com.example.dspahija.travelguide.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dspahija.travelguide.R;
import com.example.dspahija.travelguide.models.Place;

import java.util.List;


public class CustomListAdpter_CategoriesPlaces extends ArrayAdapter<Place> {


    public CustomListAdpter_CategoriesPlaces(Activity context, List<Place> place) {
        super(context, R.layout.listplace_categories, place);

    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(getContext());
        View rowView=inflater.inflate(R.layout.listplace_categories, parent,false);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.name);
        TextView imageView = (TextView) rowView.findViewById(R.id.description);

        Place place = getItem(position);

        txtTitle.setText(place.getName());
        imageView.setText(place.getDescription());
        return rowView;
    }
}
