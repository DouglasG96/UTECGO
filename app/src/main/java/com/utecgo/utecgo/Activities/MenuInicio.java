package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jorge.utecgo.R;

public class MenuInicio extends AppCompatActivity {

    Button btnIngresar;
    Button btnRegistro;
    Button btnExterno;
    ImageButton btnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicio);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getSupportActionBar().hide();

        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnRegistro=(Button)findViewById(R.id.btnRegistro);
        btnExterno=(Button)findViewById(R.id.btnExterno);
        btnImg=(ImageButton)findViewById(R.id.btnImg);


        final Intent vIngreso=new Intent(getApplicationContext(),Login.class);
        final Intent vRegistro=new Intent(getApplicationContext(),Registro1.class);
        final Intent vUser=new Intent(getApplicationContext(),PerfilUsuario.class);
        final Intent vMap=new Intent(getApplicationContext(),MapLocation.class);
        final Intent vMenu=new Intent(getApplicationContext(),ContenedorActivity.class);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferenciasUsuarios=getSharedPreferences("preferenciasUsuarios",MODE_PRIVATE);

                if(preferenciasUsuarios.getString("usuario_key",null)==null && preferenciasUsuarios.getString("pass_key",null)==null )
                {
                    startActivity(vIngreso);

                }
                else
                {
                    startActivity(vMenu);

                }

            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);

            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(vRegistro);
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);

            }
        });


        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(vUser);



            }
        });






    }
}
