package com.jorge.utecgo.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by jorge on 06/11/2017.
 */

public class Net {


    Context mContext;

    public Net(Context mContext)
    {
        this.mContext=mContext;
    }


    public boolean comprobarRed(){

        boolean rs=false;


        ConnectivityManager connectivityManager=(ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net=connectivityManager.getActiveNetworkInfo();

        if(net!=null && net.isConnected()){

            rs=true;

        }

        return rs;

    }}