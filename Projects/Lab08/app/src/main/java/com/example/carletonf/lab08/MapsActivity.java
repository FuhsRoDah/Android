package com.example.carletonf.lab08;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner mapSpin;
    String location;
    static float zoom = 8f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapSpin = (Spinner) findViewById(R.id.mapSpin);

        mapSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(mapSpin.getSelectedItem().equals("Hometown")) {
                    LatLng hometown = new LatLng(39.9268, -75.0246);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hometown, zoom));

                }
                else if(mapSpin.getSelectedItem().equals("Current Town")) {
                    LatLng currenttown = new LatLng(33.8360, -79.0478);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currenttown, zoom));
                }
                else if(mapSpin.getSelectedItem().equals("Want to Visit")){
                    LatLng visit = new LatLng(24.5551, -81.7800);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(visit, zoom));
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String location = String.valueOf(mapSpin.getSelectedItem());
        LatLng hometown = new LatLng(39.9268, -75.0246);
        mMap.addMarker(new MarkerOptions().position(hometown).title("Marker in Hometown(Cherry Hill, NJ)"));
        LatLng currenttown = new LatLng(33.8360, -79.0478);
        mMap.addMarker(new MarkerOptions().position(currenttown).title("Marker in current town (Conway, SC)"));
        LatLng visit = new LatLng(24.5551, -81.7800);
        mMap.addMarker(new MarkerOptions().position(visit).title("Marker in place I want to visit(Key West, FL)"));
        // Add a marker in Sydney and move the camera

    }
}
