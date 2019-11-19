package com.jorge.utecgo.Activities;

import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jorge.utecgo.ui.auditorios.AuditoriosFragment;
import com.jorge.utecgo.ui.edificios.EdificiosFragment;
import com.jorge.utecgo.Activities.fragments.EnfermeriasFragment;
import com.jorge.utecgo.R;
import com.jorge.utecgo.model.Lugares;
import com.jorge.utecgo.model.Picture;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

public class ContenedorActivity extends AppCompatActivity {
    ArrayList<Picture> pictures=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);
        BottomBar bottomBar=(BottomBar)findViewById(R.id.buttombar);
        bottomBar.setDefaultTab(R.id.Edificios);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.Edificios:
                        //Parametro 1 para recurar los edificios
                        MyAsyncTask mostrar=new MyAsyncTask("1");
                        mostrar.execute("1");
                        break;
                    case R.id.Laboratorios:
                        //Opcion dos para mostrar los Laboratorios
                        MyAsyncTask mostrar2=new MyAsyncTask("2");
                        mostrar2.execute("2");
                        break;
                    case R.id.Auditorios:
                        //Opcion 3 para mostrar los Auditorios
                        AuditoriosFragment fragmentAud=new AuditoriosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentAud).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;
                    case R.id.Emfermerias:
                        //Opcion cuatro para mostrar las enfermerias
                        EnfermeriasFragment fragmentEnf=new EnfermeriasFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentEnf).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;
                }
            }
        });

    }

    class MyAsyncTask extends AsyncTask<String,Void,ArrayList<Picture>>
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
            /*
            switch(tipo){
                case "1":
                    EdificiosFragment fragmentEdif=new EdificiosFragment();
                    fragmentEdif.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentEdif).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
                case "2":
                    LaboratoriosFragment fragmentLab=new LaboratoriosFragment();
                    fragmentLab.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentLab).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
            */
            EdificiosFragment fragmentEdif = new EdificiosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentEdif).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
        }
    }
}



