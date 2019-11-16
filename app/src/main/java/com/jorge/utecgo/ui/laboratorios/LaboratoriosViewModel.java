package com.jorge.utecgo.ui.laboratorios;

import android.arch.lifecycle.ViewModel;

import com.jorge.utecgo.model.Picture;

import java.util.ArrayList;

public class LaboratoriosViewModel extends ViewModel
{
    private ArrayList<Picture> pictures = new ArrayList<Picture>();

    public LaboratoriosViewModel()
    {

    }
    public LaboratoriosViewModel(ArrayList<Picture> pictures) {
        this.pictures=pictures;
    }

    public ArrayList<Picture>getLista()
    {
        return pictures;
    }
}
