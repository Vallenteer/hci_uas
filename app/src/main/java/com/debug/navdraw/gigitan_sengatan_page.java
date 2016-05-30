package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class gigitan_sengatan_page extends AppCompatActivity {

    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gigitan_sengatan_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ExpandList = (ExpandableListView) findViewById(R.id.lvExp);
        ExpandList.setChildDivider(getResources().getDrawable(R.drawable.list_divider));
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(gigitan_sengatan_page.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Sengatan lebah", "Gigitan ular","Sengatan ubur-ubur"};

        String country_names[] = {
                "<b>Segera hubungi atau bawa penderita ke fasilitas kesehatan terdekat</b> apabila penderita digigit oleh ular berbisa.",
                "Tenangkan penderita. Cuci lukanya dengan air mengalir",
                "Pastikan bagian yang terluka tidak bergerak dan ditempatkan lebih rendah dari posisi jantung. Penderita tidak diperbolehkan untuk berjalan jika tidak perlu."

        };

        int Images[] = {
                R.drawable.icon_angka_satu, R.drawable.icon_angka_dua, R.drawable.icon_angka_tiga};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 3;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            if (group_name.equals("Sengatan lebah")) {
                gru.setItems(ch_list);
                list.add(gru);
            }
            else
            {
                for (; j < size; j++) {


                    Child ch = new Child();
                    ch.setName(country_names[j]);
                    ch.setImage(Images[j]);
                    ch_list.add(ch);

                }
                gru.setItems(ch_list);

                list.add(gru);
            }
        }



        return list;
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
            Intent intent = new Intent(gigitan_sengatan_page.this, search_function.class);
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
