package com.cs6a.pet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Users extends AppCompatActivity {

    DBClass db;
    ArrayList<UsersClass> userList;
    Usersadapter adptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        ListView list = findViewById(R.id.list);
        userList = new ArrayList<>();
        db = new DBClass(this);
        List<UsersClass> users = db.getAllUsers();
        for(UsersClass us : users){
            userList.add(us);
        }
        adptr = new Usersadapter(this,R.layout.layout_list,userList);
        list.setAdapter(adptr);

    }
}
