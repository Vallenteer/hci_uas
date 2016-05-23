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
public class page_menu_activity extends Fragment {

    Button button_asma_page;
    ArrayList<Button> button_lain = new ArrayList<>(5); //Subject To change later (Richie) button-button lain yang lom jelas

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.content_main, container, false);

        // Setup handles to view objects here
        button_asma_page = (Button) view.findViewById(R.id.page_asma);
        button_asma_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ft = MainActivity.fm.beginTransaction();
                MainActivity.ft.replace(R.id.ux_content, new asma_page(),"Asma");
                MainActivity.ft.commit();

            }
        });

        //add button lain yang ga jelas (Richie)
        //Blame belleh for those id names
        //button_lain.add((Button) view.findViewById(R.id.page_menu_button_motor));
        //button_lain.add((Button) view.findViewById(R.id.button2));
        //button_lain.add((Button) view.findViewById(R.id.button3));
        //button_lain.add((Button) view.findViewById(R.id.button5));
        //button_lain.add((Button) view.findViewById(R.id.button6));

        for (Button buttons : button_lain) {
            buttons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"Unavailable",Toast.LENGTH_LONG).show();
                }
            });
        }

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Pertolongan pertama");
        return view;
    }
}
