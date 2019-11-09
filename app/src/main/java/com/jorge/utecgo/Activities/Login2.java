package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Net;
import com.jorge.utecgo.model.Usuarios;

public class Login2 extends AppCompatActivity {

    Usuarios usuario=new Usuarios();
    Button btnIngresar;
    TextView lblUsuario;
    EditText edPass;
    Usuarios us=new Usuarios();
    CheckBox checkBox;
    TextView recuperar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final Net n=new Net(this);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        lblUsuario=(TextView)findViewById(R.id.lblUsuario);
        edPass=(EditText)findViewById(R.id.input_pass);
        recuperar=(TextView) findViewById(R.id.tvRecuperar);
        lblUsuario.setText("Usuario " + Usuarios.usuario);
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recuperar=new Intent(getApplicationContext(),Recuperar_contrasena.class);
                startActivity(recuperar);
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n.comprobarRed())
                {
                    if(edPass.length()==0)
                    {
                        Toast.makeText(Login2.this, "Contraseña requerida", Toast.LENGTH_SHORT).show();
                        edPass.requestFocus();
                    }else {
                        Thread tr = new Thread() {
                            @Override
                            public void run() {
                                String encPass=usuario.md5(edPass.getText().toString());
                                final String res = usuario.verificarClave(Usuarios.usuario, encPass);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        int r = usuario.objJSON(res);
                                        if (r > 0) {
                                            Intent i = new Intent(getApplicationContext(),MenuUtecGo.class);
                                            SharedPreferences preferenciasUsuarios=getSharedPreferences("preferenciasUsuarios",MODE_PRIVATE);
                                            SharedPreferences.Editor editor=preferenciasUsuarios.edit();
                                            if(checkBox.isChecked())
                                            {
                                                editor.putString("usuario_key",Usuarios.usuario);
                                                editor.putString("pass_key",edPass.getText().toString());
                                                editor.commit();
                                            }
                                            else
                                            {
                                                editor.putString("usuario_key",null);
                                                editor.putString("pass_key",null);
                                                editor.commit();
                                            }
                                            startActivity(i);
                                            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        };
                        tr.start();
                    }
                }
                else
                {
                    Toast.makeText(Login2.this, "Necesitas conexion a Intenet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}