package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class asma_page extends AppCompatActivity {
    ListView list;

    String[] web = {
            "Bantulah penderita untuk duduk pada posisi yang nyaman.  <b>Jangan biarkan penderita berbaring.</b>",
            "Tetap tenang dan bantulah penderita untuk mengambilkan obatnya.",
            "Apabila serangan menjadi lebih berat atau penderita tidak membaik, segera hubungi fasilitas kesehatan terdekat.",
            ""

    } ;
    Integer[] imageId = {
            R.drawable.icon_angka_satu,
            R.drawable.icon_angka_dua,
            R.drawable.icon_angka_tiga,
            0

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_setting) {
            Intent intent = new Intent(asma_page.this, search_function.class);
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

}