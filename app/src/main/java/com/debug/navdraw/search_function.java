package com.debug.navdraw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class search_function extends Activity {
    ListView list;
    String[] web;

    List<String> listA;
    String[] listKosong={""};
    String[] array = {
            "Asma",
            "Gigitan/Sengatan",
            "Tersedak",
            "Epilepsi",
            "Keracunan",
            "Patah Tulang",
            "Heat Stroke",
            "Hipotemia",
            "Luka Bakar",
            "Terkilir"
    } ;
    Integer[] imageId = {
            0,0,0,0,0,0,0,0,0,0
    };
    EditText editText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);
        web=listKosong;
        editText=(EditText)findViewById(R.id.txtsearch);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeButtonEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);
        listA = new ArrayList<String>(Arrays.asList(array));
        initList();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                    // reset listview
                    if (s.toString().equals(""))
                    {
                        web=new String[0];
                        return;
                    }


                    initList();


                    // perform search
                    for (int i = 0; i <listA.size();)
                    {
                        if (listA.get(i).toLowerCase().contains(s.toString().toLowerCase()))
                        {
                            i++;
                        }
                        else
                        {
                            listA.remove(i);
                            //web.;
                        }
                        web=listA.toArray(new String[0]);
                    }
                    initList_search();

            }
            @Override
            public void afterTextChanged(Editable s) {
                initList_search();
            }

        });

    }

    public void initList_search() {
        ListAsmaAdapter adapter = new ListAsmaAdapter(search_function.this, web, imageId);
        list=(ListView)findViewById(R.id.listsearch);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);

                if(name.equals("Asma"))
                {
                    Intent intent = new Intent(search_function.this,asma_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }
                if(name.equals("Tersedak"))
                {
                    Intent intent = new Intent(search_function.this,tersedak_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }
                if(name.equals("Gigitan/Sengatan"))
                {
                    Intent intent = new Intent(search_function.this,gigitan_sengatan_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }else
                {
                    Toast.makeText(search_function.this,"Unavailable",Toast.LENGTH_LONG).show();
                }
            }


        });
    }
    public void initList() {
        web=listKosong;
        listA = new ArrayList<String>(Arrays.asList(array));
        ListAsmaAdapter adapter = new ListAsmaAdapter(search_function.this, web, imageId);
        list=(ListView)findViewById(R.id.listsearch);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);

                if(name.equals("Asma"))
                {
                    Intent intent = new Intent(search_function.this,asma_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }
                if(name.equals("Tersedak"))
                {
                    Intent intent = new Intent(search_function.this,tersedak_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }
                if(name.equals("Gigitan/Sengatan"))
                {
                    Intent intent = new Intent(search_function.this,gigitan_sengatan_page.class);
                    //based on item add info to intent
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(search_function.this,"Unavailable",Toast.LENGTH_LONG).show();
                }
            }


        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

