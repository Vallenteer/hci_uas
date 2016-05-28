package com.debug.navdraw;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

public class asma_page extends AppCompatActivity {
    ListView list;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListAsmaAdapter adapter = new ListAsmaAdapter(asma_page.this, web, imageId);
        list=(ListView)findViewById(R.id.listAsma);
        list.setAdapter(adapter);

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