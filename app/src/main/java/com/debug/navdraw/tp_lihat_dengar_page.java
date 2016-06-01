package com.debug.navdraw;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class tp_lihat_dengar_page extends AppCompatActivity {
    ListView list;
    /// benerin tulisannya dan gambarnya dikosongin yang gk pke
    // semua ini posisi gambar dkk diatur di list_tp
    String[] web = {
            "<b>Lihat</b><br> Lihat apakah dada penderita jelas naik dan turun atau mengembang saat nafas",
            "<b>Dengar</b><br> Dengarkan apakah ada pernafasan dari hidung atau mulut penderita.",
            "<b>Rasakan</b><br> Rasakan apakah ada hembusan nafas terhadap sisi wajah Anda",
            ""

    } ;
    Integer[] imageId = {
            R.drawable.icon_angka_satu,
            R.drawable.icon_angka_dua,
            R.drawable.icon_angka_tiga,
            0

    };

    Integer[] imageId2 = {
            R.drawable.illustrasi_ldr,// 0 kalau gambar kosong
            0,
            0

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_lihat_dengar_page);

        ListTPAdapter adapter = new ListTPAdapter(tp_lihat_dengar_page.this, web, imageId,imageId2);
        list=(ListView)findViewById(R.id.listview_lihat);
        list.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
            Intent intent = new Intent(tp_lihat_dengar_page.this, search_function.class);
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
    }
    public void tombol_darurat_page_open(View view) {
        //buka intent tombol darurat
        Intent intent = new Intent(this, tombol_darurat_page.class);
        startActivity(intent);

    }
}