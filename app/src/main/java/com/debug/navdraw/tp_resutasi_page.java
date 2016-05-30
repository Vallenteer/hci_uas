package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class tp_resutasi_page extends AppCompatActivity {
    ListView list;
    /// benerin tulisannya dan gambarnya dikosongin yang gk pke
    // semua ini posisi gambar dkk diatur di list_tp
    String[] web = {
            "Baringkan penderita di atas permukaan yang datar dan keras. Berlututlah sejajar di sisi kiri atau kanan dengan dada penderita",
            "Tumpuk kedua telapak tangan Anda secara sejajar mengarah pada lengan penderita dengan posisi panggung tangan berada di atas dan letakan pada bagian tengah dada penderita.",
            "Lipat telapak tangan yang berada di atas mengarah ke bagian dalam telapak tangan dibawahnya.",
            "Lakukan penekanan pada dada ke bawah sedalam 4-5 cm dengan tetap menjaga lengan Anda tetap tegak lurus, kemudia lepaskan tekanan.",
            "Terus lakukan penekanan sambil menghitung untuk menjaga jeda waktu antara penekanan tetap konstan sampai bantuan tiba.",
            ""
    } ;
    Integer[] imageId = {
            R.drawable.icon_angka_satu,
            R.drawable.icon_angka_dua,
            R.drawable.icon_angka_tiga,
            R.drawable.icon_angka_empat,
            R.drawable.icon_angka_lima,
            0

    };
    Button button_audio;
    boolean audio=true;
    Integer[] imageId2 = {
            0,
            0,// 0 kalau gambar kosong
            R.drawable.illustrasi_jantung,
            0,
            0,
            0,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_resutasi_page);

        button_audio=(Button) findViewById(R.id.button_audio);
        ListTPAdapter adapter = new ListTPAdapter(tp_resutasi_page.this, web, imageId,imageId2);
        list=(ListView)findViewById(R.id.listview_resultasi);
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
            Intent intent = new Intent(tp_resutasi_page.this, search_function.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void audio_on  (View view) {
        if(audio)
        {
            button_audio.setBackgroundResource(R.drawable.audio_on);
            audio=false;

        }
        else {
            button_audio.setBackgroundResource(R.drawable.audio_off);
            audio=true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}