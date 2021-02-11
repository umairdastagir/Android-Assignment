package com.cs6a.pet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Vehadapter extends ArrayAdapter {

    private Context context;
    private ArrayList<VehClass> VehList;
    private int layout;

    public Vehadapter(Context context, int layout, ArrayList<VehClass> VehList) {
        super(context,layout,VehList);
        this.context = context;
        this.VehList = VehList;
        this.layout = layout;
    }

    private class ViewHolder{
        TextView txtmade;
        TextView txtreg;
        TextView txtmodel;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        Vehadapter.ViewHolder holder = null;
        if(v == null) {
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            v = layoutInflater.inflate(layout,parent, false);
            holder = new Vehadapter.ViewHolder();
            holder.txtmade = v.findViewById(R.id.txtmade);
            holder.txtreg = v.findViewById(R.id.txtreg);
            holder.txtmodel = v.findViewById(R.id.txtmodel);
            v.setTag(holder);
        }
        else{
            holder = (Vehadapter.ViewHolder)v.getTag();
        }
        VehClass datalist = VehList.get(position);
        holder.txtmade.setText(datalist.made);
        holder.txtreg.setText(datalist.reg);
        holder.txtmodel.setText(datalist.model);
        return v;
    }
}

