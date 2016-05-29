package com.debug.navdraw;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;

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

        ExpandList = (ExpandableListView) findViewById(R.id.lvInfo);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(tentang_informasi_handler_activity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Informasi lainya");
        return view;
    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Bayi", "Orang Dewasa"};

        String country_names[] = {
                "Minta penderita untuk batuk. Jika belum berhasil, bungkukkan penderita sehingga posisi kepala lebih rendah dari dada", "Tepuk punggung penderita sebanyak 5 kali sambil memeriksa apakah penderita sudah tidak lagi tersedak.", "Jika masih belum berhasil, berdirilah di belakang penderita dan lingkarkan kedua lengan anda ke pinggang penderita.", "Kepalkan salah satu tangan Anda di atas pusar penderita dan genggam erat kepalan dengan tangan yang lain.", "Tekan kuat ke dalam perut mengarah ke atas dengan cepat. Lakukan sambil memeriksa apakah penderita sudah tidak lagi tersedak. Jika tidak berhasil, segera hubungi fasilitas kesehatan terdekat.."};

        int Images[] = {
                R.drawable.icon_angka_satu, R.drawable.icon_angka_dua, R.drawable.icon_angka_tiga, R.drawable.icon_angka_empat, R.drawable.icon_angka_lima};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 4;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            if (group_name.equals("Bayi")) {
                gru.setItems(ch_list);
                list.add(gru);
            }
            else
            {
                for (; j < size; j++) {


                    Child ch = new Child();
                    ch.setName(country_names[j]);
                    ch.setImage(Images[j]);
                    ch_list.add(ch);

                }
                gru.setItems(ch_list);

                list.add(gru);
            }
        }



        return list;
    }
}
