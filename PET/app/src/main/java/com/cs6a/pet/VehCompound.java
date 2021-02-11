package com.cs6a.pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VehCompound extends AppCompatActivity {

    DBClass db;
    ArrayList<VehClass> VehList;
    Vehadapter adptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veh_compound);

        ListView list = findViewById(R.id.listcmp);
        VehList = new ArrayList<>();
        db = new DBClass(this);
        List<VehClass> users = db.getAllVeh();
        for(VehClass us : users){
            VehList.add(us);
        }
        adptr = new Vehadapter(this,R.layout.layout_cmp,VehList);
        list.setAdapter(adptr);
    }
}
