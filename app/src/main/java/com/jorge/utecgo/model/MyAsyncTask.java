package com.jorge.utecgo.model;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LogPrinter;

import com.jorge.utecgo.ui.edificios.EdificiosFragment;
import com.jorge.utecgo.ui.laboratorios.LaboratoriosFragment;
import com.jorge.utecgo.ui.edificios.EdificiosViewModel;
import com.jorge.utecgo.ui.laboratorios.LaboratoriosViewModel;

import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<String,Void, ArrayList<Picture>>
{
    public String tipo;
    public MyAsyncTask(String tipo){
        this.tipo=tipo;

        Log.d("CONSTRUCTOR", "***********************************************************");
    }
    @Override
    protected ArrayList<Picture> doInBackground(String... params) {
        Log.d("DOINBACKGROUND", "***********************************************************");

        ArrayList<Picture> pictures=new ArrayList<Picture>();
        Lugares l=new Lugares();
        Log.d("CONTENIDO", l.toString());
        String json=l.listarLugares(tipo);

        Log.d("CONTENIDO2", json);
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
                Log.d("Render" , "Edificios Render");

                break;
            case "2":
                LaboratoriosViewModel laboratoriosViewModel = new LaboratoriosViewModel(result);
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

