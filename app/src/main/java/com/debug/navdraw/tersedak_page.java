package com.debug.navdraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class tersedak_page extends AppCompatActivity {

    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tersedak_page);

        ExpandList = (ExpandableListView) findViewById(R.id.lvExp);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(tersedak_page.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);



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
            if(group_name == "Orang Dewasa")
            {
                ch_list = new ArrayList<Child>();
                for (; j < size; j++) {
                    Child ch = new Child();
                    ch.setName(country_names[j]);
                    ch.setImage(Images[j]);
                    ch_list.add(ch);
                }
                gru.setItems(ch_list);
                list.add(gru);

                size = size + 4;
            }

        }

        return list;
    }

}
