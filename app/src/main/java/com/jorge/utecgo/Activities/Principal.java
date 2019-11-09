package com.jorge.utecgo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jorge.utecgo.R;

public class Principal extends AppCompatActivity {


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);




    }
}
