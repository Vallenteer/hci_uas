package com.debug.navdraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tutorial_page_3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_page_3);
    }

    public void lanjut_page4_open(View view) {

        Intent intent = new Intent(tutorial_page_3.this, tutorial_page_4.class);
        startActivity(intent);
        finish();

    }
}
