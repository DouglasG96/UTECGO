package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jorge.utecgo.R;
//import com.squareup.picasso.Picasso;

public class PictureDetaills extends AppCompatActivity {

    FloatingActionButton fabDetalle;
    ImageView imageHeader;
    TextView dependencias;
    String lat;
    String lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detaills);


        Toolbar toolbar = findViewById(R.id.toolbarScroll1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fabDetalle = findViewById(R.id.fabDetalle);
        imageHeader = findViewById(R.id.imageHeader);
        dependencias = findViewById(R.id.dependencias);
        Intent intent=getIntent();
        final String urlImagen=intent.getStringExtra("foto");
        String depen=intent.getStringExtra("dependencias");
        final String nombre=intent.getStringExtra("nombre");

        dependencias.setText(depen);

        lat=intent.getStringExtra("latitud");
        lng=intent.getStringExtra("longitud");
        Glide.with(getApplication()).load(urlImagen).into(imageHeader);

        CollapsingToolbarLayout collapser =
                (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapser.setTitle(nombre);


        fabDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent i=new Intent(getApplicationContext(),MapLocation.class);
                i.putExtra("latitud",lat);
                i.putExtra("longitud",lng);
                i.putExtra("nombre",nombre);
                i.putExtra("foto",urlImagen);

                startActivity(i);

            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
