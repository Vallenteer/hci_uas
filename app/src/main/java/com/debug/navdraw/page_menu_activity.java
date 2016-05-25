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
// kalau pindah fragment nanti kelvin yang atur
        // Setup handles to view objects here
     //   button_asma_page = (Button) view.findViewById(R.id.page_asma);
       // button_asma_page.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   MainActivity.ft = MainActivity.fm.beginTransaction();
               // MainActivity.ft.replace(R.id.ux_content, new tersedak_page(),"Asma");
                //MainActivity.ft.commit();

           // }
        //});
// ampe sini
        //add button lain yang ga jelas (Richie)
        //Blame belleh for those id names
        button_lain.add((Button) view.findViewById(R.id.page_epilepsi));
        button_lain.add((Button) view.findViewById(R.id.page_heatStroke));
        button_lain.add((Button) view.findViewById(R.id.page_hipotermia));
        button_lain.add((Button) view.findViewById(R.id.page_keracunan));
        button_lain.add((Button) view.findViewById(R.id.page_patahTulang));
        button_lain.add((Button) view.findViewById(R.id.page_terkilir));
        button_lain.add((Button) view.findViewById(R.id.page_lukaBakar));

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
