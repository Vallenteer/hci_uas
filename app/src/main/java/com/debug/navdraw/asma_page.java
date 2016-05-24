package com.debug.navdraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class asma_page extends AppCompatActivity {

    private ExpandableListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_page);

        ExpandList = (ExpandableListView) findViewById(R.id.lvExp);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandableListAdapter(asma_page.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);



    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = { "Bayi", "Orang Dewasa"};

        String country_names[] = { "Minta penderita untuk batuk. Jika belum berhasil bungkukkan penderita, tepuk punggung bagian", "Tepuk punggung",
        "Tabokin orangnya", "Jangan kasih ampun"};

        int Images[] = { R.drawable.icon_angka_satu, R.drawable.icon_angka_dua,
                R.drawable.icon_angka_satu, R.drawable.icon_angka_dua};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 2;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setImage(Images[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 2;
        }

        return list;
    }

}
