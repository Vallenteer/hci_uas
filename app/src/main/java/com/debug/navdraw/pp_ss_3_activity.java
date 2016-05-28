package com.debug.navdraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kelvin Kristianto on 24/05/2016.
 */
public class pp_ss_3_activity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.pp_ss_3_fragment, container, false);


        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Pemeriksaan penderita");
        return view;
    }
}
