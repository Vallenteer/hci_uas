package com.debug.navdraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tutorial_page_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_page_2);
    }

    public void lanjut_page3_open(View view) {

        Intent intent = new Intent(tutorial_page_2.this, tutorial_page_3.class);
        startActivity(intent);
        finish();

    }
}
