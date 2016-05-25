package com.debug.navdraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kelvin Kristianto on 24/05/2016.
 */
public class tentang_informasi_handler_activity extends Fragment {

    ArrayList<Button> button_lain = new ArrayList<>(5); //Subject To change later (Richie) button-button lain yang lom jelas

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.tentang_informasi_fragment, container, false);

        for (Button buttons : button_lain) {
            buttons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"Unavailable",Toast.LENGTH_LONG).show();
                }
            });
        }

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Informasi lainya");
        return view;
    }
}
