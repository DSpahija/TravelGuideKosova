package com.example.dspahija.travelguide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.dspahija.travelguide.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        this.mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);

    }

    private void WindowText(Marker marker, View view){
        String title = marker.getTitle();
        TextView textViewTitle = (TextView) view.findViewById(R.id.title_PlaceInfo);

        if(!title.equals("")){
            textViewTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView textViewSnippet = (TextView) view.findViewById(R.id.snippet_PlaceInfo);

        if(!snippet.equals("")){
            textViewSnippet.setText(snippet);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        WindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        WindowText(marker, mWindow);
        return mWindow;
    }
}
