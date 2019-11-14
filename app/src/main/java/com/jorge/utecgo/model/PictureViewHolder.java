package com.jorge.utecgo.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorge.utecgo.R;

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

