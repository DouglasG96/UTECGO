package com.utecgo.utecgo.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.utecgo.utecgo.R;
import com.squareup.picasso.Picasso;

public class PictureDetaills extends AppCompatActivity {

    FloatingActionButton fabDetalle;
    ImageView imageHeader;
    TextView dependencias;
    TextView nomEdif;
    String lat;
    String lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detaills);
        getSupportActionBar().hide();

        fabDetalle=(FloatingActionButton)findViewById(R.id.fabDetalle);
        imageHeader=(ImageView)findViewById(R.id.imageHeader);
        dependencias=(TextView)findViewById(R.id.dependencias);
        nomEdif=(TextView)findViewById(R.id.nomEdificio);

        Intent intent=getIntent();

        String urlImagen=intent.getStringExtra("foto");
        String depen=intent.getStringExtra("dependencias");
        String nombre=intent.getStringExtra("nombre");

        dependencias.setText(depen);
        nomEdif.setText(nombre);
        lat=intent.getStringExtra("latitud");
        lng=intent.getStringExtra("longitud");
        Picasso.with(getApplicationContext()).load(urlImagen).into(imageHeader);


        fabDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent i=new Intent(getApplicationContext(),MapLocation.class);
                i.putExtra("latitud",lat);
                i.putExtra("longitud",lng);
                i.putExtra("nombre",nomEdif.getText());

                startActivity(i);

            }
        });




    }
}
