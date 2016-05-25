package com.debug.navdraw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class asma_page extends Activity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] angkaImage={R.drawable.icon_angka_satu,R.drawable.icon_angka_dua,R.drawable.icon_angka_tiga};
    public static String[] asmaText={"c++","JAVA","Jsp"};
    TextView textView = (TextView) findViewById(R.id.tv_Asma);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_page);

        context=this;

        lv=(ListView) findViewById(R.id.listAsma);
        lv.setAdapter(new ListAsmaAdapter(this,asmaText,angkaImage));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
