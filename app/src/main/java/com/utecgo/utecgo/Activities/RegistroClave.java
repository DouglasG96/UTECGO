package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorge.utecgo.Activities.Principal;
import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Net;
import com.jorge.utecgo.model.Usuarios;

import org.json.JSONArray;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class RegistroClave extends AppCompatActivity {

    Usuarios us=new Usuarios();
    Button btnRegistrar;
    EditText edClave;
    EditText edClave2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_clave);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Net n=new Net(this);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                edClave=(EditText)findViewById(R.id.edClave);
                edClave2=(EditText)findViewById(R.id.edClave2);

                if(n.comprobarRed())
                {


                    if(edClave.getText().toString().equals(edClave2.getText().toString()))
                    {



                        final String EncPassword=md5(edClave.getText().toString());


                        Thread tr1=new Thread(){

                            @Override
                            public void run() {


                                final String respuesta = enviarPost(Usuarios.usuario,EncPassword,Usuarios.pregunta);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        int r = objJSON(respuesta);

                                        if (r == 0) {

                                            Toast.makeText(getApplicationContext(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent(getApplicationContext(), ContenedorActivity.class);

                                            startActivity(i);

                                            overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                                        } else {



                                            Toast.makeText(getApplicationContext(), "Usuario no registrado", Toast.LENGTH_SHORT).show();

                                        }



                                    }
                                });



                            }
                        };
                        tr1.start();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Los campos no coinciden", Toast.LENGTH_SHORT).show();

                    }


                }
                else{


                    Toast.makeText(RegistroClave.this, "Necesitas conexion a internet", Toast.LENGTH_SHORT).show();


                }




            }
        });

    }



    private static final String md5(final String password) {
        try {

            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public String enviarPost(String usuario,String clave,String respuesta)
    {

        String parametros="usuario="+usuario+"&clave="+clave+"&pregunta="+respuesta;
        HttpURLConnection conex=null;
        String rs="";

        try{
            URL url=new URL("https://utecgo.appwebsv.com/regUs.php");
            conex=(HttpURLConnection)url.openConnection();
            conex.setRequestMethod("POST");
            conex.setRequestProperty("Content-Length", "" + Integer.toString(parametros.getBytes().length));

            conex.setDoOutput(true);
            DataOutputStream wr=new DataOutputStream(conex.getOutputStream());
            wr.writeBytes(parametros);
            wr.close();

            Scanner sc=new Scanner(conex.getInputStream());

            while(sc.hasNextLine())
            {
                rs+=(sc.nextLine());
            }

        }
        catch(Exception ex)
        {
        }
        return rs;


    }



    public int objJSON(String rspta)
    {
        int rs=0;

        try{
            JSONArray json=new JSONArray(rspta);
            rs=(json.length()>0)?1:0;
        }
        catch (Exception ex)
        {
        }
        return rs;

    }




}
