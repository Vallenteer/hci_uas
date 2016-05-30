package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        ExpandList.setChildDivider(getResources().getDrawable(R.drawable.list_divider));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Bayi", "Orang Dewasa"};

        String country_names[] = {
        "Minta penderita untuk batuk. Jika belum berhasil, bungkukkan penderita sehingga posisi kepala lebih rendah dari dada",
                "Tepuk punggung penderita sebanyak 5 kali sambil memeriksa apakah penderita sudah tidak lagi tersedak.",
                "Jika masih belum berhasil, berdirilah di belakang penderita dan lingkarkan kedua lengan anda ke pinggang penderita.",
                "Kepalkan salah satu tangan Anda di atas pusar penderita dan genggam erat kepalan dengan tangan yang lain.",
                "Tekan kuat ke dalam perut mengarah ke atas dengan cepat. Lakukan sambil memeriksa apakah penderita sudah tidak lagi tersedak. Jika tidak berhasil, segera hubungi fasilitas kesehatan terdekat.",

        };

        int Images[] = {
        R.drawable.icon_angka_satu, R.drawable.icon_angka_dua, R.drawable.icon_angka_tiga, R.drawable.icon_angka_empat, R.drawable.icon_angka_lima};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 5;
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                    finish();
                return true;
        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_setting) {
            Intent intent = new Intent(tersedak_page.this, search_function.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }  public void tombol_darurat_page_open(View view) {
        //buka intent tombol darurat
        Intent intent = new Intent(this, tombol_darurat_page.class);
        startActivity(intent);

    }
}
