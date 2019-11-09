package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorge.utecgo.Activities.Pregunta;
import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Usuarios;

public class VerificacionCodigo extends AppCompatActivity {

    Usuarios us=new Usuarios();
    Button btnVerificar;
    EditText edCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_codigo);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btnVerificar=(Button)findViewById(R.id.btnVerificar);
        edCodigo=(EditText)findViewById(R.id.edCodigo);


        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String codigo=Usuarios.codigo;


                if(codigo.equals(edCodigo.getText().toString()))
                {

                    Intent i=new Intent(getApplicationContext(),Pregunta.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);


                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Codigo Incorrecto", Toast.LENGTH_SHORT).show();

                }






            }
        });






    }
}
