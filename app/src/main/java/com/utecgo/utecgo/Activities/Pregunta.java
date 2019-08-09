package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Usuarios;

public class Pregunta extends AppCompatActivity {


    Usuarios us=new Usuarios();
    Button btnSiguiente;
    EditText edPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();


        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        edPregunta=(EditText)findViewById(R.id.edPregunta);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(edPregunta.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Campo Requerido!!", Toast.LENGTH_SHORT).show();
                }
                else if(edPregunta.getText().toString().length()<6)
                {

                    Toast.makeText(getApplicationContext(), "Ingresa un respuesta de almenos 6 caracteres", Toast.LENGTH_SHORT).show();
                }
                else
                {



                    Usuarios.pregunta=(edPregunta.getText().toString());

                    Intent i = new Intent(getApplicationContext(), RegistroClave.class);

                    startActivity(i);

                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);


                }








            }
        });




    }
}
