package com.jorge.utecgo.model;
import android.os.AsyncTask;

import com.jorge.utecgo.ui.laboratorios.LaboratoriosFragment;
import com.jorge.utecgo.ui.edificios.EdificiosViewModel;
import com.jorge.utecgo.ui.laboratorios.LaboratoriosViewModel;

import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<String,Void, ArrayList<Picture>>
{
    public String tipo;
    public MyAsyncTask(String tipo){
        this.tipo=tipo;
    }
    @Override
    protected ArrayList<Picture> doInBackground(String... params) {
        ArrayList<Picture> pictures=new ArrayList<>();
        Lugares l=new Lugares();
        String json=l.listarLugares(tipo);
        try {
            pictures=l.parseJsonFile(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pictures;
    }

    protected void onPostExecute(ArrayList<Picture> result) {
        switch (tipo)
        {
            case "1":
                EdificiosViewModel edificiosViewModel = new EdificiosViewModel(result);
                break;
            case "2":
                LaboratoriosViewModel laboratoriosFragment = new LaboratoriosViewModel(result);
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            default:

                break;
        }
    }
}

