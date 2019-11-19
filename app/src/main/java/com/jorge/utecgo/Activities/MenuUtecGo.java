package com.jorge.utecgo.Activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jorge.utecgo.ui.bibliotecas.BibliotecasFragment;
import com.jorge.utecgo.ui.auditorios.AuditoriosFragment;
import com.jorge.utecgo.model.Lugares;
import com.jorge.utecgo.model.Picture;
import com.jorge.utecgo.ui.edificios.EdificiosFragment;
import com.jorge.utecgo.Activities.fragments.GmapFragment;
import com.jorge.utecgo.ui.laboratorios.LaboratoriosFragment;
import com.jorge.utecgo.R;

import java.util.ArrayList;

public class MenuUtecGo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        EdificiosFragment.OnFragmentInteractionListener,
        LaboratoriosFragment.OnFragmentInteractionListener,
        AuditoriosFragment.OnFragmentInteractionListener,
        BibliotecasFragment.OnFragmentInteractionListener,
        GmapFragment.OnFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;

    private Fragment fragmentoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utec_go);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        /*
            NavigationUI.setupWithNavController(navigationView, navController);
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_utec_go, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean onOptionItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.opt_configuracion) {
           Toast.makeText(this,"Aqui van las configuracione o preferencias", Toast.LENGTH_SHORT).show();
           return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment f = null;
        boolean fragmentSeleccionado = false;
        int id = item.getItemId();
        String banderaAsyncTask = "";
        if (id == R.id.nav_edificios)
        {
            banderaAsyncTask = "1";
            fragmentoSeleccionado = new EdificiosFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_laboratorios)
        {
            banderaAsyncTask = "2";
            fragmentoSeleccionado = new LaboratoriosFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_auditorios)
        {
            banderaAsyncTask = "3";
            fragmentoSeleccionado = new AuditoriosFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_bibliotecas)
        {
            banderaAsyncTask = "4";
            fragmentoSeleccionado = new EdificiosFragment();
            fragmentSeleccionado = true;
        }

        if(fragmentSeleccionado)
        {
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            MyAsyncTask myAsyncTask= new MyAsyncTask(banderaAsyncTask);
            myAsyncTask.execute(banderaAsyncTask);
            //getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmentoSeleccionado).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uir)
    {

    }

    class MyAsyncTask extends AsyncTask<String,Void, ArrayList<Picture>>
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

            switch(tipo){
                case "1":
                    EdificiosFragment fragmentEdif = new EdificiosFragment();
                    fragmentEdif.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmentEdif).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
                case "2":
                    LaboratoriosFragment fragmentLab = new LaboratoriosFragment();
                    fragmentLab.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragmentLab).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
                case "3":
                    AuditoriosFragment auditoriosFragment = new AuditoriosFragment();
                    auditoriosFragment.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_main,auditoriosFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
                case "4":
                    BibliotecasFragment bibliotecasFragment = new BibliotecasFragment();
                    bibliotecasFragment.setLista(result);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_main,bibliotecasFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                    break;
            }
            //getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentoSeleccionado).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
            Log.d("Render ",  "Edificios");
        }
    }
}
