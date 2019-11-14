package com.jorge.utecgo.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;
import com.jorge.utecgo.Activities.fragments.AuditoriosFragment;
import com.jorge.utecgo.Activities.fragments.EdificiosFragment;
import com.jorge.utecgo.Activities.fragments.EnfermeriasFragment;
import com.jorge.utecgo.Activities.fragments.GmapFragment;
import com.jorge.utecgo.Activities.fragments.LaboratoriosFragment;
import com.jorge.utecgo.Prueba;
import com.jorge.utecgo.R;
import com.jorge.utecgo.model.MyAsyncTask;
import com.jorge.utecgo.ui.home.HomeFragment;

public class MenuUtecGo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        Prueba.OnFragmentInteractionListener,
        AuditoriosFragment.OnFragmentInteractionListener,
        EnfermeriasFragment.OnFragmentInteractionListener,
        EdificiosFragment.OnFragmentInteractionListener,
        LaboratoriosFragment.OnFragmentInteractionListener,
        GmapFragment.OnFragmentInteractionListener {

    private AppBarConfiguration mAppBarConfiguration;

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
        Fragment f = new HomeFragment();
        if(f!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,f).commit();
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

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

    /*
    public boolean onOptionItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.opt_cuenta) {
            Intent i=new Intent(getApplicationContext(),PerfilUsuario.class);
            startActivity(i);
        } else if (id == R.id.opt_laboratorios) {
            Intent i=new Intent(getApplicationContext(),ContenedorActivity.class);
            startActivity(i);
        } else if (id == R.id.opt_edificios) {

        } else if (id == R.id.opt_bibliotecas) {
            Intent i=new Intent(getApplicationContext(),MenuInicio.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

            */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment f = null;
        boolean fragmentSeleccionado = false;
        int id = item.getItemId();
        if (id == R.id.opc_auditorios)
        {
            Log.i("msg","Auditorios");
            /*
            f = new AuditoriosFragment();
            fragmentSeleccionado = true;
             */
        }
        if (id == R.id.opc_enfermerias)
        {
            Log.i("msg","Enfermerias");
            /*
            f = new AuditoriosFragment();
            fragmentSeleccionado = true;
             */
        }
        else if (id == R.id.opc_cuenta)
        {
            Log.i("msg","Cuenta");
            /*
            Intent i=new Intent(getApplicationContext(),PerfilUsuario.class);
            startActivity(i);
            */
        }
        else if (id == R.id.opc_laboratorios)
        {
            f = new LaboratoriosFragment();
            fragmentSeleccionado = true;
            MyAsyncTask llenarLaboratorios = new MyAsyncTask();
            llenarLaboratorios.setTipo("2");
            Log.i("msg","Laboratorios");
            /*
            LaboratoriosFragment framentLaboratorios = new LaboratoriosFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_home,framentLaboratorios,"Laboratorios");
            fragmentTransaction.commit();
            fragmentManager.beginTransaction().replace(
                    R.id.nav_home, new LaboratoriosFragment()
            ).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
            */
        }
        else if (id == R.id.opc_edificios)
        {
            f = new EdificiosFragment();
            fragmentSeleccionado = true;
            MyAsyncTask llenarEdificios = new MyAsyncTask();
            llenarEdificios.setTipo("1");
            Log.i("msg","Edificios");
            //Toast.makeText(this,"Edificios",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.opc_bibliotecas)
        {
            Log.i("msg","bibliotecas");
        }

        else if (id == R.id.opc_prueba)
        {
            Log.i("msg","Prueba");
            f = new Prueba();
            fragmentSeleccionado = true;
        }

        if(fragmentSeleccionado)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,f).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uir)
    {

    }
}
