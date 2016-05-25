package com.debug.navdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.app.Activity;
import android.app.ActivityManager;
import android.text.Html;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class asma_page extends AppCompatActivity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] angkaImage={R.drawable.icon_angka_satu,R.drawable.icon_angka_dua,R.drawable.icon_angka_tiga};
    public static String [] asmaText={"c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    TextView textView = (TextView) findViewById(R.id.tv_Asma);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_page);

        context=this;

        lv=(ListView) findViewById(R.id.listAsma);
        lv.setAdapter(new ListAsmaAdapter(asma_page.this ,asmaText,angkaImage));
    }


}
