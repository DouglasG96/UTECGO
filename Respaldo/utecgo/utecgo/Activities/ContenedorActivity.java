package com.utecgo.utecgo.Activities;

import android.os.AsyncTask;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.utecgo.utecgo.Activities.fragments.AuditoriosFragment;
import com.utecgo.utecgo.Activities.fragments.EdificiosFragment;
import com.utecgo.utecgo.Activities.fragments.EnfermeriasFragment;
import com.utecgo.utecgo.Activities.fragments.LaboratoriosFragment;
import com.utecgo.utecgo.R;
import com.utecgo.utecgo.model.Lugares;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.utecgo.utecgo.model.Picture;

import java.util.ArrayList;

public class ContenedorActivity extends AppCompatActivity {

    ArrayList<Picture> pictures=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        getSupportActionBar().hide();

        BottomBar bottomBar=(BottomBar)findViewById(R.id.buttombar);
        bottomBar.setDefaultTab(R.id.Edificios);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                switch (tabId){


                    case R.id.Edificios:

                        MyAsyncTask mostrar=new MyAsyncTask();

                        //Opcion 1 para mostrar los edificios
                        mostrar.execute("1");


                        break;

                    case R.id.Laboratorios:

                        LaboratoriosFragment fragmentLab=new LaboratoriosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentLab).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();

                        break;

                    case R.id.Auditorios:
                        AuditoriosFragment fragmentAud=new AuditoriosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentAud).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();



                        break;

                    case R.id.Emfermerias:

                        EnfermeriasFragment fragmentEnf=new EnfermeriasFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentEnf).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();


                        break;



                }



            }
        });

    }

    class MyAsyncTask extends AsyncTask<String,Void,ArrayList<Picture>>
    {


        @Override
        protected ArrayList<Picture> doInBackground(String... params) {

            ArrayList<Picture> pictures=new ArrayList<>();

            Lugares l=new Lugares();

            String json=l.listarLugares("1");

            try {
                pictures=l.parseJsonFile(json);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return pictures;

        }


        protected void onPostExecute(ArrayList<Picture> result) {

            EdificiosFragment fragmentEdif=new EdificiosFragment();
            fragmentEdif.setLista(result);
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentEdif).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();

        }




    }



}



