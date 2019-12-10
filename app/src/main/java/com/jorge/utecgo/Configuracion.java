package com.jorge.utecgo;

import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Configuracion extends AppCompatActivity {

    private Switch switch_thema;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        //toolbar2
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        switch_thema = findViewById(R.id.switch_thema);

        toolbar.setTitle("Configuraciones");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);



        final SharedPreferences sharedPreferences = getSharedPreferences("preferenciasUsuarios",MODE_PRIVATE);

        String c = sharedPreferences.getString("nav_color" , null);

        if(c!=null){
            switch_thema.setChecked(true);
        }


        switch_thema.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor=sharedPreferences.edit();

                if(isChecked){
                    editor.putString("nav_color","#000");

                }else{
                    editor.putString("nav_color",null);
                }


                editor.commit();

                //String color_selected =  sharedPreferences.getString("nav_color", null);
                //Log.d("color" ,color_selected);
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
