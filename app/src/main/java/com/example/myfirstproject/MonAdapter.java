package com.example.myfirstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {

    public static ArrayList <Contact> d;
    Context con;

 MonAdapter(Context con, ArrayList <Contact> d){
     this.d=d;
     this.con=con;

 }
    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Contact getItem(int i) {
        return d.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inf=LayoutInflater.from(con);
        LinearLayout l=(LinearLayout)inf.inflate(R.layout.view_contact,null);
        TextView tvnom=l.findViewById(R.id.tvnom_view);
        TextView tvprenom=l.findViewById(R.id.tvprenom_view);
        TextView tvnum=l.findViewById(R.id.tvnum_view);

        Contact c= getItem(i);

        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnum.setText(c.num);

        return l;
    }
}
