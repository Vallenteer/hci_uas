package com.debug.navdraw;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tombol_darurat_page extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tombol_darurat_page);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ambulan_fragment(), "AMBULANS");
        adapter.addFragment(new rumahsakit_fragment(), "RUMAH SAKIT");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }



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
            Intent intent = new Intent(tombol_darurat_page.this, search_function.class);
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
    }  public void tombol_darurat_page_open(View view) {
        //buka intent tombol darurat
        Intent intent = new Intent(this, tombol_darurat_page.class);
        startActivity(intent);

    }
    public void call_118(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:021118"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void call_119(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:021119"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void call_betsaida(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:02129309999"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void call_carolus(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:02154220811"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void call_ass(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0215384314"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void call_siloam(View view)
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0215460055"));
        try{
            startActivity(intent);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }

    //API Key GMaps :  AIzaSyBfWtUxkoTrT6N6luJvdB6etsKlRTc4QHY

    public void directBethsaida(View view)
    {
        Intent intent = new Intent( Intent.ACTION_VIEW,
                Uri.parse("https://www.google.co.id/maps/place/Bethsaida+Hospitals/@-6.2546947,106.6202553,17z/data=!4m15!1m9!4m8!1m0!1m6!1m2!1s0x2e69fc7a082d017f:0x212d083e3a5e9c49!2sJl+Boulevard+Raya+Gading+Serpong+Kav+29+Gading+Serpong,+Bethsaida+Hospitals,+Kec.+Tangerang,+Banten!2m2!1d106.622444!2d-6.2547!3m4!1s0x2e69fc7a082d017f:0x212d083e3a5e9c49!8m2!3d-6.2547!4d106.622444?hl=en"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK&Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public void directCarolus(View view)
    {
        Intent intent = new Intent( Intent.ACTION_VIEW,
                Uri.parse("https://www.google.co.id/maps/place/St.+Carolus+Hospital+Summarecon+Serpong/@-6.2546679,106.6136892,15z/data=!4m8!1m2!2m1!1scarolus+serpong!3m4!1s0x2e69fb90893fbba1:0x406e4656855a7250!8m2!3d-6.2471031!4d106.6423491?hl=en"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK&Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public void directAsobirin(View view)
    {
        Intent intent = new Intent( Intent.ACTION_VIEW,
                Uri.parse("https://www.google.co.id/maps/place/Rumah+Sakit+Islam+Asshobirin/@-6.2591347,106.6493513,17z/data=!3m1!4b1!4m5!3m4!1s0x2e69fb9f51da473d:0x5e416ce53e8a0915!8m2!3d-6.25914!4d106.65154?hl=en"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK&Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public void directSiloam(View view)
    {
        Intent intent = new Intent( Intent.ACTION_VIEW,
                Uri.parse("https://www.google.co.id/maps/place/Siloam+Hospitals+Lippo+Village/@-6.2250979,106.596171,17z/data=!3m1!4b1!4m5!3m4!1s0x2e69fc276fd19173:0xef3df4d1a093f06a!8m2!3d-6.2251032!4d106.5983597?hl=en"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK&Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
    public void move_rumahsakit(View view)
    {
        viewPager.setCurrentItem(2,true);
    }
}
