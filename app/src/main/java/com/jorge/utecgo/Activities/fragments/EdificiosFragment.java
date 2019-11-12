package com.jorge.utecgo.Activities.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorge.utecgo.Prueba;
import com.jorge.utecgo.R;
import com.jorge.utecgo.adapter.PictureAdapterRecyclerView;
import com.jorge.utecgo.model.Lugares;
import com.jorge.utecgo.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EdificiosFragment extends Fragment {
    private Prueba.OnFragmentInteractionListener mListener;
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


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Prueba.OnFragmentInteractionListener) {
            mListener = (Prueba.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
