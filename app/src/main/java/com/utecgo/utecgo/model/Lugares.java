package com.utecgo.utecgo.model;


import org.json.JSONArray;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Lugares {


    //Devuelve un conjunto de lugares en formato JSON
    public String listarLugares(String tipo)
    {


        String parametros="tipo="+tipo;
        HttpURLConnection conex=null;
        String rs="";

        try{
            URL url=new URL("http://utecgo.appwebsv.com/listaLugares.php");
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

    //Devuelve un ArrayList generico de tipo Picture para llenar los adaptadores (para los RecyclerView) de las listas del los diferentes tipos de lugares
    public ArrayList<Picture> parseJsonFile(String jsonStr) throws Exception{


        ArrayList<Picture> arr=new ArrayList<Picture>();

        JSONArray lugares =new JSONArray(jsonStr);


        for(int i=0;i<lugares.length();i++)
        {
            String foto=lugares.getJSONObject(i).getString("foto");
            String nombre=lugares.getJSONObject(i).getString("nombre");
            String direccion=lugares.getJSONObject(i).getString("descripcion");
            String dependencias=lugares.getJSONObject(i).getString("dependencias");
            String latitud=lugares.getJSONObject(i).getString("latitud");
            String longitud=lugares.getJSONObject(i).getString("longitud");
            arr.add(new Picture(foto,nombre,direccion,dependencias,latitud,longitud));
        }

        return arr;
    }








}
