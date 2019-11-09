package com.jorge.utecgo.Activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.jorge.utecgo.R;
import com.jorge.utecgo.adapter.WindowAdapter;
import com.jorge.utecgo.modules.DirectionFinder;
import com.jorge.utecgo.modules.DirectionFinderListener;
import com.jorge.utecgo.modules.Route;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MapLocation extends FragmentActivity implements OnMapReadyCallback,DirectionFinderListener {

        private GoogleMap mMap;
        private List<Marker> originMarkers = new ArrayList<>();
        private List<Marker> destinationMarkers = new ArrayList<>();
        private List<Polyline> polylinePaths = new ArrayList<>();
        private ProgressDialog progressDialog;
        private Marker marcadorDestino;
        private ImageView imagenMarker;


        Location location;


        //Valores de destino
        private double latDestino=0.0;
        private double lngDestino=0.0;
        String nombreDestino="";
        String url="";


        //Valores del usuario
        private double latUsuario=0.0;
        private double lngUsuario=0.0;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_map_location);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);



        }


    private void sendRequest() {
            String origin = latUsuario+","+lngUsuario;
            String destination = latDestino+","+lngDestino;

            try {
                new DirectionFinder(this, origin, destination).execute();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            mMap.setInfoWindowAdapter(new WindowAdapter(MapLocation.this));

            Intent anterior=getIntent();
            latDestino=Double.parseDouble(anterior.getStringExtra("latitud"));
            lngDestino=Double.parseDouble(anterior.getStringExtra("longitud"));
            nombreDestino=anterior.getStringExtra("nombre");
            url=anterior.getStringExtra("foto");


            //Obteniendo la ubicacion actual de el usuario
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            location = (locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));

            latUsuario=location.getLatitude();
            lngUsuario=location.getLongitude();



            sendRequest();




        }


        @Override
        public void onDirectionFinderStart() {
            progressDialog = ProgressDialog.show(this, "Porfavor espere.",
                    "Buscando Direcciones..!", true);

            if (originMarkers != null) {
                for (Marker marker : originMarkers) {
                    marker.remove();
                }
            }

            if (destinationMarkers != null) {
                for (Marker marker : destinationMarkers) {
                    marker.remove();
                }
            }

            if (polylinePaths != null) {
                for (Polyline polyline:polylinePaths ) {
                    polyline.remove();
                }
            }


        }

        @Override
        public void onDirectionFinderSuccess(List<Route> routes) {
            progressDialog.dismiss();
            polylinePaths = new ArrayList<>();
            originMarkers = new ArrayList<>();
            destinationMarkers = new ArrayList<>();



            for (Route route : routes) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
                ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
                ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

                originMarkers.add(mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_me))
                        .title(route.startAddress)
                        .position(route.startLocation)
                        )

                );

                marcadorDestino=mMap.addMarker(new MarkerOptions()
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_edf))
                        .title(nombreDestino)
                        .position(route.endLocation)
                        .snippet(url)
                );


                destinationMarkers.add(marcadorDestino);




                PolylineOptions polylineOptions = new PolylineOptions().
                        geodesic(true).
                        color(Color.rgb(63,165,65)).
                        width(4);

                for (int i = 0; i < route.points.size(); i++)
                    polylineOptions.add(route.points.get(i));

                polylinePaths.add(mMap.addPolyline(polylineOptions));
            }
        }
}

