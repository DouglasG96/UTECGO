package com.jorge.utecgo.Activities;

import android.net.Uri;
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
        if (id == R.id.nav_auditorios)
        {
            Log.i("msg","Auditorios");
            f = new AuditoriosFragment();
            fragmentSeleccionado = true;
        }
        if (id == R.id.nav_enfermerias)
        {
            Log.i("msg","Enfermerias");
            f = new AuditoriosFragment();
            fragmentSeleccionado = true;
        }
        else if (id == R.id.nav_cuenta)
        {
            Log.i("msg","Cuenta");
        }
        else if (id == R.id.nav_laboratorios)
        {
            banderaAsyncTask = "2";
            f = new LaboratoriosFragment();
            fragmentSeleccionado = true;
            Log.i("msg","Laboratorios");
        }
        else if (id == R.id.nav_edificios)
        {
            banderaAsyncTask = "1";
            f = new EdificiosFragment();
            fragmentSeleccionado = true;
            Log.i("msg","Edificios");
        }
        else if (id == R.id.nav_bibliotecas)
        {
            Log.i("msg","bibliotecas");
        }
        else if (id == R.id.nav_prueba)
        {
            Log.i("msg","Prueba");
            f = new Prueba();
            fragmentSeleccionado = true;
        }

        if(fragmentSeleccionado)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,f).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
            MyAsyncTask myAsyncTask= new MyAsyncTask(banderaAsyncTask);
            myAsyncTask.execute(banderaAsyncTask);
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
