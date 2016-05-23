package com.debug.navdraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class asma_page extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.activity_asma_page, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Asma");
        MainActivity.IsPageHome=false;
        return  view;
    }
}
