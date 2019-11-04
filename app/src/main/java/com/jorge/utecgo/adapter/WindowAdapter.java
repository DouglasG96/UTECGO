package com.jorge.utecgo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.jorge.utecgo.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jorge on 26/11/2017.
 */

public class WindowAdapter implements GoogleMap.InfoWindowAdapter {


    private final View mWindow;
    private Context mContext;
    private Bitmap btm;

    public WindowAdapter(Context context) {
        mContext=context;
        mWindow= LayoutInflater.from(context).inflate(R.layout.ventana_informacion,null);
    }


    private void rendowWindowText(Marker marker,View view)
    {

        String title=marker.getTitle();
        TextView tvTitle=(TextView)view.findViewById(R.id.window_title);

        if(!title.equals("")){

            tvTitle.setText(title);

        }




        String description=marker.getTitle();
        TextView tvDescription=(TextView)view.findViewById(R.id.window_description);

        if(!title.equals("")){

            tvDescription.setText(description);

        }

        ImageView image=(ImageView)view.findViewById(R.id.window_image);
        //image.setImageResource(R.drawable.benito);

        Glide.with(view.getContext()).load(marker.getSnippet()).override(100,100).error(R.drawable.ic_me).into(image);


    }


    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker,mWindow);

        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker,mWindow);
        return mWindow;
    }


}



