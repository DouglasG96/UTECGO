package com.jorge.utecgo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jorge.utecgo.Activities.PictureDetaills;
import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Picture;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jorge on 18/10/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures,int resource,Activity activity)
    {
        this.pictures=pictures;
        this.resource=resource;
        this.activity=activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        final Picture picture=pictures.get(position);
        final String nombre=picture.getNombreEdificio();
        holder.nombreEdificio.setText(picture.getNombreEdificio());
        holder.descripcionCard.setText(picture.getDireccion());
        Glide.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(activity, PictureDetaills.class);
                i.putExtra("nombre",picture.getNombreEdificio());
                i.putExtra("dependencias",picture.getDependencias());
                i.putExtra("foto",picture.getPicture());
                i.putExtra("latitud",picture.getLatitud());
                i.putExtra("longitud",picture.getLongitud());

                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView nombreEdificio;
        private TextView descripcionCard;

        public PictureViewHolder(View itemView)
        {
            super(itemView);
            pictureCard= itemView.findViewById(R.id.imagenCard);
            nombreEdificio= itemView.findViewById(R.id.nombreEdificio);
            descripcionCard= itemView.findViewById(R.id.direccion);
        }
    }

}