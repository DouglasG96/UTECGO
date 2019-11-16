package com.jorge.utecgo.ui.edificios;

import android.arch.lifecycle.ViewModel;

import com.jorge.utecgo.model.Picture;

import java.util.ArrayList;

public class EdificiosViewModel extends ViewModel
{
    private ArrayList<Picture> pictures = new ArrayList<Picture>();

    public EdificiosViewModel()
    {

    }
    public EdificiosViewModel(ArrayList<Picture> pictures) {
        this.pictures=pictures;
    }

    public ArrayList<Picture>getLista()
    {
        return pictures;
    }
}
