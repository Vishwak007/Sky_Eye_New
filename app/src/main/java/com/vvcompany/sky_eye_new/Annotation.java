package com.vvcompany.sky_eye_new;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.geojson.Point;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;
import com.mapbox.maps.Style;

public class Annotation extends AppCompatActivity implements LocationEngine {
    MapView mapView;
    MapboxMap mapboxMap;
    String style = Style.MAPBOX_STREETS;
    LocationEngineResult locationEngineResult;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        mapView = findViewById(R.id.mapView);
        mapboxMap = mapView.getMapboxMap();
//        style = getIntent().getStringExtra("style");
        mapView.getMapboxMap().loadStyleUri(style);
//        if (style.isEmpty()){
//            mapboxMap.loadStyleUri(Style.MAPBOX_STREETS);
//
//        }else{
//            mapboxMap.loadStyleUri(style);
//        }

        addAnnotation();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addAnnotation() {
        Point point = mapboxMap.getCameraState().getCenter();

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_location_on_24);
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.ic_baseline_location_on_24);
//        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions().withPoint(point);
//
//        MapDelegateProvider delegateProvider = pointAnnotationOptions.
//        AnnotationConfig annotationConfig = new AnnotationConfig();

//        PointAnnotationManager pointAnnotationManager = mapView.
//        double x = locationEngineResult.getLastLocation().getLongitude();
//        double y = locationEngineResult.getLastLocation().getLatitude();

//        @SuppressLint("ResourceType") PointerIcon pointerIcon = PointerIcon.load(getResources(), R.drawable.ic_baseline_location_on_24);
//        PointerIcon pointerIcon1 = PointerIcon.create(icon, (float)40.7128, (float)-74.0060);
//        mapView.setPointerIcon(pointerIcon1);

    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_menu, menu);
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
                Intent intent = new Intent(this, MainActivity.class);

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

    @Override
    public void getLastLocation(@NonNull LocationEngineCallback<LocationEngineResult> locationEngineCallback) throws SecurityException {
        locationEngineCallback.onSuccess(locationEngineResult);
    }

    @Override
    public void requestLocationUpdates(@NonNull LocationEngineRequest locationEngineRequest, @NonNull LocationEngineCallback<LocationEngineResult> locationEngineCallback, @Nullable Looper looper) throws SecurityException {

    }

    @Override
    public void requestLocationUpdates(@NonNull LocationEngineRequest locationEngineRequest, PendingIntent pendingIntent) throws SecurityException {

    }

    @Override
    public void removeLocationUpdates(@NonNull LocationEngineCallback<LocationEngineResult> locationEngineCallback) {

    }

    @Override
    public void removeLocationUpdates(PendingIntent pendingIntent) {

    }
}