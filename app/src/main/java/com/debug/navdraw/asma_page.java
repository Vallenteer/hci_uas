package com.debug.navdraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class asma_page extends AppCompatActivity {
    ListView list;

    String[] web = {
            "Google Plus  <b>\"This is an emergency\"</b> aaaaaaaaaaaaaaaaaaaaaaaa",
            "Twitter",
            "Windows"

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

        ListAsmaAdapter adapter = new ListAsmaAdapter(asma_page.this, web, imageId);
        list=(ListView)findViewById(R.id.listAsma);
        list.setAdapter(adapter);

    }

}