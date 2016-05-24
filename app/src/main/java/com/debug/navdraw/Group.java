package com.debug.navdraw;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class Group {

    private String Name;
    private ArrayList<Child> Items;

    public String getName() {
        return Name;
    }

    private static class GroupHolder{ ImageView img; TextView Name; }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }

}