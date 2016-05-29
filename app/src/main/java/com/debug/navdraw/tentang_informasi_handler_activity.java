package com.debug.navdraw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kelvin Kristianto on 24/05/2016.
 */
public class tentang_informasi_handler_activity extends Fragment {

    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

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

        ExpandList = (ExpandableListView) view.findViewById(R.id.lvInfo);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Informasi lainya");
        return view;
    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Pada saat seperti apa pemeriksaan penderita dibutuhkan?", "Tentang P3KU"};

        String country_names[] = {
                "Pemeriksaan penderita dapat digunakan untuk mengetahui kondisi yang sebenarnya dialami oleh penderita pada saat kita tidak mengetahui penyebab kondisi penderita tersebut",
                "P3KU (Panduan Pertolongan PertamaKu) adalah sebuah aplikasi yang memberikan informasi tentang cara penanganan untuk berbagai macam keadaan darurat. Aplikasi P3KU dapat digunakan untuk mempelajari cara-cara penanganan dan juga dapat digunakan saat darurat untuk memeriksa penderita dan mencari pertolongan dari fasilitas kesehatan terdekat."};

        int Images[] = {
               0,0};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
                for (; j < size; j++) {


                    Child ch = new Child();
                    ch.setName(country_names[j]);
                    ch.setImage(Images[j]);
                    ch_list.add(ch);

                }
                gru.setItems(ch_list);

                list.add(gru);
            size=size+1;
        }



        return list;
    }
}
