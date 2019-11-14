package com.jorge.utecgo.model;
import android.os.AsyncTask;

import com.jorge.utecgo.Activities.fragments.EdificiosFragment;
import com.jorge.utecgo.Activities.fragments.LaboratoriosFragment;
import com.jorge.utecgo.R;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<String,Void, ArrayList<Picture>>
{
    private String tipo;
    Lugares l=new Lugares();
    public MyAsyncTask()
    {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    protected ArrayList<Picture> doInBackground(String... params) {
        ArrayList<Picture> pictures=new ArrayList<>();
        String json=l.listarLugares(this.getTipo());
        try {
            pictures=l.parseJsonFile(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pictures;
    }

    protected void onPostExecute(ArrayList<Picture> result) {
        String banderaTipo = this.getTipo();
        switch (banderaTipo)
        {
            case "1":
                EdificiosFragment edificiosFragment = new EdificiosFragment();
                edificiosFragment.setLista(result);
                break;
            case "2":
                LaboratoriosFragment laboratoriosFragment = new LaboratoriosFragment();
                laboratoriosFragment.setLista(result);
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
        }
    }
}

