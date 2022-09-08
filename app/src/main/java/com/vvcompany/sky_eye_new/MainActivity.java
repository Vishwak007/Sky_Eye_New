package com.vvcompany.sky_eye_new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;

public class MainActivity extends AppCompatActivity {
    MapView mapView;
    MapboxMap mapboxMap;
    String style = Style.MAPBOX_STREETS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        mapboxMap = mapView.getMapboxMap();
        style = getIntent().getStringExtra("style");
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS);
//        if (style.equals("")){
//            mapboxMap.loadStyleUri(Style.MAPBOX_STREETS);
//
//        }else{
//            mapboxMap.loadStyleUri(style);
//        }
//        mapboxMap.loadStyleUri(style);
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.style1:
                style = Style.MAPBOX_STREETS;
                mapView.getMapboxMap().loadStyleUri(style);
                return true;
            case R.id.style2:
                style = Style.DARK;
                mapView.getMapboxMap().loadStyleUri(style);
                return true;

            case R.id.style3:
                style = Style.TRAFFIC_DAY;
                mapView.getMapboxMap().loadStyleUri(style);
                return true;

            case R.id.style4:
                style = Style.OUTDOORS;
                mapView.getMapboxMap().loadStyleUri(style);
                return true;

            case R.id.task1:
                Intent intent = new Intent(this, Annotation.class);

                intent.putExtra("style", style);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}