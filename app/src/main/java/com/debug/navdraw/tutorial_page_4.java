package com.debug.navdraw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class tutorial_page_4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_page_4);
    }

    public void lanjut_homepage_open(View view) {
        //if pertama buka
        //Intent intent = new Intent(tutorial_page_4.this, MainActivity.class);
        //startActivity(intent);
        finish();

    }
    public void close_page(View view){
        finish();
    }
}
