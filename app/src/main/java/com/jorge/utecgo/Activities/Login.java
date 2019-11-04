package com.jorge.utecgo.Activities;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Net;
import com.jorge.utecgo.model.Usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends AppCompatActivity {

    Usuarios us=new Usuarios();
    Button btnSiguiente;
    EditText edUsuario;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Net n=new Net(this);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        final Intent viewPass=new Intent(getApplicationContext(),Login2.class);

        btnSiguiente=(Button)findViewById(R.id.btnIngresar);
        edUsuario=(EditText)findViewById(R.id.input_user);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                if(n.comprobarRed())
                {


                    if(edUsuario.getText().toString().length()==0)
                    {
                        Toast.makeText(getApplicationContext(), "Campo requerido", Toast.LENGTH_SHORT).show();
                        edUsuario.requestFocus();
                    }
                    else if(edUsuario.getText().toString().length()<10)
                    {
                        Toast.makeText(getApplicationContext(), "Debes ingresar un carnet con 10 caracteres", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Date date = new Date();
                        String formato="yyyy";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                        int anioActual=Integer.parseInt(dateFormat.format(date));

                        int anioIngresado=Integer.parseInt(edUsuario.getText().toString().substring(6));

                        int pos7=Integer.parseInt(String.valueOf(edUsuario.getText().toString().charAt(6)));
                        int pos8=Integer.parseInt(String.valueOf(edUsuario.getText().toString().charAt(7)));


                        if(anioIngresado<=anioActual && pos7==2 && pos8==0 )
                        {

                            Thread tr = new Thread() {

                                @Override
                                public void run() {

                                    final Usuarios usuario=new Usuarios();
                                    final String respuesta =usuario.verificarUsuario(edUsuario.getText().toString());

                                    Usuarios.usuario=edUsuario.getText().toString();

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            int r = usuario.objJSON(respuesta);

                                            if (r > 0) {

                                                Intent i = new Intent(getApplicationContext(), Login2.class);

                                                startActivity(i);

                                                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                                            } else {
                                                Toast.makeText(getApplicationContext(), "Usuario no registrado", Toast.LENGTH_SHORT).show();

                                            }

                                        }
                                    });


                                }
                            };
                            tr.start();

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Numero de carnet invalido", Toast.LENGTH_SHORT).show();

                        }


                    }

                }
                else
                {
                    Toast.makeText(Login.this, "Necesitas conexion a internet", Toast.LENGTH_SHORT).show();

                }





            }
        });


    }

}
