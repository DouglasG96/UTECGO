package com.jorge.utecgo.Activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jorge.utecgo.R;

public class PerfilUsuario extends AppCompatActivity {



    Button btnComprobacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        getSupportActionBar().hide();

        btnComprobacion=(Button)findViewById(R.id.btnComprobacion);


        btnComprobacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

                if(networkInfo!=null && networkInfo.isConnected())
                {

                    Toast.makeText(PerfilUsuario.this, "Estas conectado", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(PerfilUsuario.this, "No estas conectado", Toast.LENGTH_SHORT).show();

                }






            }
        });




    }
}
