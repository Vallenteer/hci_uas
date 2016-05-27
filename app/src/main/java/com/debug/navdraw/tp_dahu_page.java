package com.debug.navdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class tp_dahu_page extends AppCompatActivity {
    ListView list;
    /// benerin tulisannya dan gambarnya dikosongin yang gk pke
    String[] web = {
            "Bantulah penderitauntuk duduk pada posisi yang nyaman.  <b>Jangan biarkan penderita berbaring</b>",
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
        setContentView(R.layout.activity_tp_dahu_page);

        ListTPAdapter adapter = new ListTPAdapter(tp_dahu_page.this, web, imageId,imageId2);
        list=(ListView)findViewById(R.id.listview_dahu);
        list.setAdapter(adapter);

    }

}