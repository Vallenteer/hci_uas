package com.debug.navdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static FragmentTransaction ft;
    public static FragmentManager fm;
    Intent intent;
    public static boolean IsPageHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Boolean isFirstRun= getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("isfirstrun",true);
        if(isFirstRun){
            Intent intent = new Intent(MainActivity.this, tutorial_page_0.class);
            startActivity(intent);
            getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
        }


        fm = getSupportFragmentManager();
        //init fragment
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new page_menu_activity());
        ft.commit();
        IsPageHome=true;

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
                if (!IsPageHome) {

                    ft = fm.beginTransaction();
                    ft.replace(R.id.ux_content, new page_menu_activity());
                    ft.commit();
                    IsPageHome = true;
                    getSupportActionBar().setTitle("P3KU");
                    // yang belom itu cm ngilangin highlight ke beranda,,, daku dk ketmu carana .-.
                }
                else{
                    super.onBackPressed();
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_setting) {
            Intent intent = new Intent(MainActivity.this, search_function.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pertolongan) {
            // Handle the camera action
            IsPageHome=true;
            ft = fm.beginTransaction();
            ft.replace(R.id.ux_content, new page_menu_activity(),"Pertolongan pertama");
            ft.commit();


        } else if (id == R.id.nav_pemeriksaan) {
            IsPageHome=false;
            ft = fm.beginTransaction();
            ft.replace(R.id.ux_content, new pp_airway_1_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
            ft.commit();
        } else if (id == R.id.nav_teknik) {
            IsPageHome=false;
            ft = fm.beginTransaction();
            ft.replace(R.id.ux_content, new tp_handler_activity(),"Teknik penanganan"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
            ft.commit();
        }  else if (id == R.id.nav_tutorial) {
            IsPageHome=false;
            ft = fm.beginTransaction();
            ft.replace(R.id.ux_content, new tutorial_handler_activity(),"Tutorial P3KU"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
            ft.commit();

        } else if (id == R.id.nav_info) {
            IsPageHome=false;
            ft = fm.beginTransaction();
            ft.replace(R.id.ux_content, new tentang_informasi_handler_activity(),"Informasi lainnya"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void tersedak_page_open(View view) {
        //buka intent tersedak
        Intent intent = new Intent(MainActivity.this, tersedak_page.class);
        startActivity(intent);

    }
    public void asma_page_open(View view) {
        //buka intent asma
        Intent intent = new Intent(MainActivity.this, asma_page.class);
        startActivity(intent);

    }
    public void gigitan_sengatan_page_open(View view) {
        //buka intent gigitan
        Intent intent = new Intent(MainActivity.this, gigitan_sengatan_page.class);
        startActivity(intent);

    }
    public void tombol_darurat_page_open(View view) {
        //buka intent tombol darurat
        Intent intent = new Intent(MainActivity.this, tombol_darurat_page.class);
        startActivity(intent);

    }
    public void angkat_dagu_page_open(View view) {

        Intent intent = new Intent(MainActivity.this, tp_dahu_page.class);
        startActivity(intent);

    }
    public void play_tutorial_open(View view) {

        Intent intent = new Intent(MainActivity.this, tutorial_page_0.class);
        startActivity(intent);

    }
    public void pp_airway1No_open (View view) {
        //open airway 2
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_airway_2_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }

    public void pp_airway1Yes_open  (View view) {
        //open breathing 1
       ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_breathing_1_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }

    public void pp_airway2No_open (View view) {
        //open airway 4
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_airway_4_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_airway2Yes_open  (View view) {
        //open airway 3
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_airway_3_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_breathing1Yes_open  (View view) {
        //open circu 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_circu_1_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_breathing1No_open  (View view) {
        //open breathing 2
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_breathing_2_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }

    public void pp_breathing2Yes_open  (View view) {
        //open bearthing 3
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_breathing_3_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_breathing2No_open  (View view) {
        //open breathing 4
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_breathing_4_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_circu1Yes_open  (View view) {
        //open circu 2
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_circu_2_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_circu1No_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_1_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }

    public void pp_ss1Yes_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_2_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_ss1No_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_3_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_ss2Yes_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_4_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_ss2No_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_5_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }public void pp_ss3Yes_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_6_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void pp_ss3No_open  (View view) {
        //open SS 1
        ft = fm.beginTransaction();
        ft.replace(R.id.ux_content, new pp_ss_7_activity(),"Pemeriksaan penderita"); // harusna ganti ke handler menunya, penamaan ini cuma buat highlight
        ft.commit();
    }
    public void resutasi_page_open  (View view) {
        //open resutasi
        Intent intent = new Intent(MainActivity.this, tp_resutasi_page.class);
        startActivity(intent);
    }
    public void ldr_page_open  (View view) {
        //open ldr
        Intent intent = new Intent(MainActivity.this, tp_lihat_dengar_page.class);
        startActivity(intent);
    }
    public void pop_1_open  (View view) {
        //open pop up 1 dagu
        Intent intent = new Intent(MainActivity.this, pop_up_dagu.class);
        startActivity(intent);
    }
    public void pop_2_open  (View view) {
        //open pop up 1 dagu
        Intent intent = new Intent(MainActivity.this, pop_up_ldr.class);
        startActivity(intent);
    }


}
