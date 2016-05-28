package com.debug.navdraw;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class tp_lihat_dengar_page extends AppCompatActivity {
    ListView list;
    /// benerin tulisannya dan gambarnya dikosongin yang gk pke
    // semua ini posisi gambar dkk diatur di list_tp
    String[] web = {
            "<b>Lihat</b><br> isi sendiri aja wkak",
            "Tetap tenang dan bantulah penderita untuk mengambilkan obatnya",
            "Apabila serangan menjadi lebih berat atau penderita tidak membaik, segera hubungi fasilitas kesehatan terdekat"

    } ;
    Integer[] imageId = {
            R.drawable.icon_angka_satu,
            R.drawable.icon_angka_dua,
            R.drawable.icon_angka_tiga

    };

    Integer[] imageId2 = {
            0,// 0 kalau gambar kosong
            R.drawable.illustrasi_asma_banner,
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
        return super.onOptionsItemSelected(item);
    }
}