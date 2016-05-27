package com.debug.navdraw;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListTPAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final Integer[] imageId2;
    public ListTPAdapter(Activity context, String[] web, Integer[] imageId,Integer[] imageId2) {
        super(context, R.layout.list_asma, web);

        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.imageId2= imageId2;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_dahu, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_dahu);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.id_angka_dahu);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.id_penanganan_gambar);
        txtTitle.setText(Html.fromHtml(web[position]) );

        imageView.setImageResource(imageId[position]);
        imageView2.setImageResource(imageId2[position]);
        return  rowView;
    }
}