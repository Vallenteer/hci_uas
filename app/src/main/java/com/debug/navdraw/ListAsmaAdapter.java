package com.debug.navdraw;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAsmaAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public ListAsmaAdapter(Activity context,String[] web, Integer[] imageId) {
        super(context, R.layout.list_asma, web);

        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_asma, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.tv_asma);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.id_angka_asma);
        txtTitle.setText(Html.fromHtml(web[position]) );

        imageView.setImageResource(imageId[position]);
        return  rowView;
    }
}