package com.jorge.utecgo.Activities.fragments;

//import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jorge.utecgo.Prueba;
import com.jorge.utecgo.R;

/**
 * Created by jorge on 17/11/2017.
 */

public class GmapFragment extends Fragment implements OnMapReadyCallback {

    private Prueba.OnFragmentInteractionListener mListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_gmaps,container,false);

        SupportMapFragment fragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fmappos);
        fragment.getMapAsync(this);
        return  rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //Tamaño predefinido para todos los marcadores
        int height = 125;
        int width = 125;

        LatLng benito_juarez = new LatLng(13.700376, -89.201921);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.benito);
        Bitmap smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(benito_juarez)
                .title("Edificio Benito Juarez")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng francisco_morazan = new LatLng(13.700401, -89.202056);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.fm1);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(francisco_morazan)
                .title("Edificio Francisco Morazan")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );


        LatLng simon_bolivar = new LatLng(13.700183 , -89.2004710);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.sb);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(simon_bolivar)
                .title("Edificio Simon Bolivar")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng fundadores = new LatLng(13.701637 , -89.201612);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.fd);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(fundadores)
                .title("Edificio Los fundadores")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );


        LatLng anastacio_aquino = new LatLng(13.700448 , -89.200250);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.aq);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(anastacio_aquino)
                .title("Edificio Anastacio Aquino")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng jose_marti = new LatLng(13.700218 , -89.200013);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.jm);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(jose_marti)
                .title("Edificio José Martí")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng claudia_lars = new LatLng(13.701427 , -89.199715);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.cl);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(claudia_lars)
                .title("Edificio Claudia Lars")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng garcia_lorca = new LatLng(13.699973 , -89.199545);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.fgl);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(garcia_lorca)
                .title("Edificio Garcia Lorca")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng tomas_jefferson = new LatLng(13.699520 , -89.199499);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.tf);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(tomas_jefferson)
                .title("Edificio Thomas Jefferson")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );


        LatLng gabriela_mistral = new LatLng(13.700734 , -89.200819);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.gm);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(gabriela_mistral)
                .title("Edificio Gabriela Mistral")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng jaa = new LatLng(13.699610 , -89.201001);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.jaa);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(jaa)
                .title("Edificio Dr. Jose Adolfo Araujo Ramagoza")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng gg = new LatLng(13.699610 , -89.201001);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.gg);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(gg)
                .title("Edificio Giuseppe Garibaldi")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );

        LatLng jlb = new LatLng(13.700912 , -89.202151);
        icon = BitmapFactory.decodeResource(getResources(), R.drawable.jlb);
        smallMarker = Bitmap.createScaledBitmap(icon, width, height, false);
        googleMap.addMarker(new MarkerOptions().position(gg)
                .title("Edificio Jorge Luis Borges")
                .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        );






        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fundadores , 18));
        googleMap.setBuildingsEnabled(true);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
