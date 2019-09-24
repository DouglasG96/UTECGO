package com.utecgo.utecgo.Activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utecgo.utecgo.R;
import com.utecgo.utecgo.adapter.PictureAdapterRecyclerView;
import com.utecgo.utecgo.model.Lugares;
import com.utecgo.utecgo.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EdificiosFragment extends Fragment {


    ArrayList<Picture> pictures;
    RecyclerView picturesRecycler;


    public EdificiosFragment() {



    }


    public void setLista(ArrayList<Picture> pictures)
    {
        this.pictures=pictures;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_edificios,container,false);

        picturesRecycler=(RecyclerView)view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView=new PictureAdapterRecyclerView(pictures,R.layout.cardview,getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);



        return view;
    }

    public ArrayList<Picture> buidPictures(){

        ArrayList<Picture> pictures =new ArrayList<>();

        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/bj.jpg","Benito Juarez","Calle arce 1114 (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/fm.JPG","Francisco Morazan","Calle arce 1026 (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/sb.jpg","Simon Bolivar","Calle arce (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/fd.jpg","Los Fundadores","1ª calle Poniente ,1138  (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/aq.jpg","Anastasio Aquino","Calle Arce 1006 (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/jm.jpg","Jose Marti","Calle Arce y 17.ª avenida Norte (San Salvador,El Salvador)","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/cl.jpg","Claudia Lars","1ª calle Poniente y 17.ª avenida Norte (San Salvador,El Salvador","","",""));
        pictures.add(new Picture("https://utecgo.appwebsv.com/images/edificios/fgl.jpg","Federico Garcia Lorca","Calle Arce y 17ª avenida Sur","","",""));


        return pictures;



    }


}
