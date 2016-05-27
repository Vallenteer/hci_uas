package com.debug.navdraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tutorial_page_0 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_page_0);
    }

    public void lanjut_page1_open(View view) {

        Intent intent = new Intent(tutorial_page_0.this, tutorial_page_1.class);
        startActivity(intent);
        finish();

    }
    public void lewati_open(View view) {

        finish();

    }
}
