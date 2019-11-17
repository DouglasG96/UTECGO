package com.jorge.utecgo.ui.edificios;

import android.util.Log;

import com.jorge.utecgo.model.Picture;

import java.util.ArrayList;

public class EdificiosViewModel
{
    private ArrayList<Picture> pictures = new ArrayList<Picture>();
    EdificiosFragment edificiosFragment;

    public EdificiosViewModel()
    {
    }

    @Override
    public String toString() {
        return "EdificiosViewModel{" +
                "pictures=" + pictures +
                ", edificiosFragment=" + edificiosFragment +
                '}';
    }

    public ArrayList<Picture> getPictures() {
        Log.i("EdificiosViewModel",toString());
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        Log.i("picturesParam",pictures.toString());
        this.pictures = pictures;
    }
}
