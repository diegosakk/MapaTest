package com.example.mapatest;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapatest.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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
        // Add a marker in Sydney and move the camera
        LatLng Los_Angeles = new LatLng(-37.4629, -72.3612);
        LatLng Santa_Barbara = new LatLng(-37.6644, -72.0246);
        LatLng Angol = new LatLng(-37.8061, -72.7038);
        mMap.addMarker(new MarkerOptions().position(Los_Angeles).title("Elei po shoro"));
        mMap.addMarker(new MarkerOptions().position(Santa_Barbara).title("Saint brarbaradas"));
        mMap.addMarker(new MarkerOptions().position(Angol).title("golazo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Los_Angeles));

        PolylineOptions POLILINEA =new PolylineOptions()
                .add(new LatLng(Los_Angeles.latitude, Los_Angeles.longitude))
                .add(new LatLng(Santa_Barbara.latitude,Santa_Barbara.longitude))
                .add(new LatLng(Angol.latitude,Angol.longitude));
        Polyline polyline=mMap.addPolyline(POLILINEA);
        PolygonOptions POLIGONO =new PolygonOptions()
                .add(new LatLng(Los_Angeles.latitude,Los_Angeles.longitude),
                        new LatLng(Santa_Barbara.latitude,Santa_Barbara.longitude),
                        new LatLng(Angol.latitude,Angol.longitude))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE);

        Polygon poligono=mMap.addPolygon(POLIGONO);


    }
}