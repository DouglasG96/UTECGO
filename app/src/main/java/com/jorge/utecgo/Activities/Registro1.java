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
import com.jorge.utecgo.model.Net;
import com.jorge.utecgo.model.Usuarios;

import org.json.JSONArray;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Registro1 extends AppCompatActivity {

    Usuarios us=new Usuarios();
    Button btnSiguiente;
    EditText edCarnet;
    int enviar=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);

        final Net n=new Net(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btnSiguiente=findViewById(R.id.btnSiguiente);
        edCarnet=findViewById(R.id.input_user);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n.comprobarRed())
                {
                    if(edCarnet.length()==0)
                    {
                        String carnet=edCarnet.getText().toString();
                        Toast.makeText(getApplicationContext(), "Campo  de usuario requerido", Toast.LENGTH_SHORT).show();
                    }
                    else if(edCarnet.length()<10)
                    {
                        Toast.makeText(getApplicationContext(), "Ingresa un carnet con 10 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Date date = new Date();
                        String formato="yyyy";
                        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                        int anioActual=Integer.parseInt(dateFormat.format(date));

                        int anioIngresado=Integer.parseInt(edCarnet.getText().toString().substring(6));

                        int pos7=Integer.parseInt(String.valueOf(edCarnet.getText().toString().charAt(6)));
                        int pos8=Integer.parseInt(String.valueOf(edCarnet.getText().toString().charAt(7)));
                        if(anioIngresado<=anioActual && pos7==2 && pos8==0 )
                        {
                            final Thread tr2=new Thread(){

                                @Override
                                public void run() {
                                    String codigo="";
                                    String carnet=edCarnet.getText().toString();

                                    int min=100999;
                                    int max=999999;
                                    int numAleatorio=(int)Math.floor(Math.random()*(min-(max+1))+(max));
                                    codigo=String.valueOf(numAleatorio);
                                    Usuarios.codigo=(codigo);
                                    final String rs=validarCorreo(carnet, codigo);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            int res=objJSON(rs);
                                            if(res==0)
                                            {
                                                Usuarios.usuario=(edCarnet.getText().toString());
                                                Toast.makeText(getApplicationContext(),"Enviado con exito" , Toast.LENGTH_SHORT).show();
                                                Intent i=new Intent(getApplicationContext(),VerificacionCodigo.class);
                                                startActivity(i);
                                                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
                                            }
                                            else
                                            {
                                                Toast.makeText(getApplicationContext(),"Correo no enviado" , Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            };
                            Thread tr=new Thread(){
                                @Override
                                public void run() {
                                    final  String respuesta= enviarPost(edCarnet.getText().toString());
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            int r = objJSON(respuesta);
                                            if (r > 0) {
                                                Toast.makeText(getApplicationContext(), "Usuario ya existente", Toast.LENGTH_SHORT).show();
                                            } else {
                                                tr2.start();
                                            }
                                        }
                                    });
                                }
                            };
                            tr.start();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Carnet ingresado es invalido ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(Registro1.this, "Necesitas conexion a internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String validarCorreo(String carnet,String codigo)
    {
        String parametros="carnet="+carnet+"&codigo="+codigo;
        HttpURLConnection conex=null;
        String rs="";
        try{
            URL url=new URL("https://utecgo.appwebsv.com/validacionCorreo.php");
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

    public String enviarPost(String usuario)
    {
        String parametros="us="+usuario;
        HttpURLConnection conex=null;
        String rs="";
        try{
            URL url=new URL("https://utecgo.appwebsv.com/validarUsuarios.php");
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