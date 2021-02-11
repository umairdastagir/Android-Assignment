package com.cs6a.pet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Usersadapter extends ArrayAdapter {
    private Context context;
    private ArrayList<UsersClass> UserList;
    private int layout;

    public Usersadapter(Context context, int layout, ArrayList<UsersClass> UserList) {
        super(context,layout,UserList);
        this.context = context;
        this.UserList = UserList;
        this.layout = layout;
    }

    private class ViewHolder{
TextView txtname;
TextView txtpass;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder = null;
if(v == null) {
    LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
    v = layoutInflater.inflate(layout,parent, false);
    holder = new ViewHolder();
    holder.txtname = v.findViewById(R.id.txtname);
    holder.txtpass = v.findViewById(R.id.txtpass);
    v.setTag(holder);
}
else{
    holder = (ViewHolder)v.getTag();
}
UsersClass datalist = UserList.get(position);
holder.txtname.setText(datalist.name);
holder.txtpass.setText(datalist.password);
return v;
    }
}
