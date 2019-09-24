package com.utecgo.utecgo.model;

/**
 * Created by jorge on 18/10/2017.
 */

public class Picture {

    private String picture;
    private String nombreEdificio;
    private String direccion;
    private String dependencias;
    private String latitud;
    private String longitud;



    public Picture(String picture,String nombreEdificio,String direccion,String dependencias,String latitud,String longitud)
    {
        this.picture=picture;
        this.nombreEdificio=nombreEdificio;
        this.direccion=direccion;
        this.dependencias=dependencias;
        this.latitud=latitud;
        this.longitud=longitud;
    }


    public void setPicture(String picture)
    {
        this.picture=picture;
    }

    public String getPicture(){

        return picture;
    }

    public void setNombreEdificio(String nombreEdificio)
    {
        this.nombreEdificio=nombreEdificio;

    }
    public String getNombreEdificio()
    {
        return nombreEdificio;

    }

    public void setDireccion(String direccion)
    {
        direccion=direccion;

    }

    public String getDireccion()
    {

        return direccion;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }


}
