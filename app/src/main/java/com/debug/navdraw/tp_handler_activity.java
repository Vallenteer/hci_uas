package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Kelvin Kristianto on 24/05/2016.
 */
public class tp_handler_activity extends Fragment {

    ListView list;

    String[] web = {
            "Angkat dagu tekan dahi",
            "Lihat, dengar, rasakan",
            "Nafas Buatan",
            "Resutasi Jantung Paru (RJP)",
            "Kontrol pendarahan",
            ""

    } ;
    Integer[] imageId = {
            R.drawable.icon_angkatdahu,
            R.drawable.icon_ldr,
            R.drawable.icon_nafas_buatan,
            R.drawable.icon_jantung,
            R.drawable.icon_darah,
            0

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.tp_1_fragment, container, false);

        ListTPHandlerAdapter adapter = new ListTPHandlerAdapter(getActivity(), web, imageId);
        list=(ListView)view.findViewById(R.id.listTP);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==0)
               {
                   Intent intent = new Intent(getActivity(), tp_dahu_page.class);
                   startActivity(intent);
               }
                if(position==1)
                {
                    Intent intent = new Intent(getActivity(), tp_lihat_dengar_page.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(getActivity(), tp_resutasi_page.class);
                    startActivity(intent);
                }


            }


        });

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Teknik penanganan");
        return view;
    }


}
