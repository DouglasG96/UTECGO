package com.jorge.utecgo.model;

import org.json.JSONArray;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by jorge on 17/09/2017.
 */
public  class Usuarios {


    public static String usuario;
    public static String codigo;
    public static String pregunta;
    public static String clave;

    public String verificarUsuario(String usuario)
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


    public String verificarClave(String usuario,String contrasena)
    {

        String parametros="us="+usuario+"&contra="+contrasena;

        HttpURLConnection conex=null;
        String rs="";

        try{
            URL url=new URL("https://utecgo.appwebsv.com/validarCuenta.php");
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


     public String md5(final String password) {
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