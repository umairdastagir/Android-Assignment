package com.cs6a.pet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBClass extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "petdb";
    private static final String TABLE_Users = "userdetails";
    private static final String TABLE_Veh = "vehdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASS = "password";
    private static final String KEY_VEHID = "vehid";
    private static final String KEY_VEHMADE = "vehmade";
    private static final String KEY_VEHMODEL = "vehmodel";
    private static final String KEY_REGNO = "regno";

    DBClass(Context context){ super(context, DB_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLEUSERS = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_PASS + " TEXT"+")";
        String CREATE_TABLEVEH = "CREATE TABLE " + TABLE_Veh + "("
                + KEY_VEHID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_VEHMADE + " TEXT,"
                + KEY_VEHMODEL + " TEXT,"+ KEY_REGNO + " TEXT "+")";
        db.execSQL(CREATE_TABLEUSERS);
        db.execSQL(CREATE_TABLEVEH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        onCreate(db);
    }

    void insertVehDetails(String made, String regno, String model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_VEHMADE, made);
        cv.put(KEY_VEHMODEL, model);
        cv.put(KEY_REGNO, regno);
        db.insert(TABLE_Veh,null, cv);
        db.close();
    }

    void insertUserDetails(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_PASS, password);
        db.insert(TABLE_Users,null, cValues);
        db.close();
    }


    public List<VehClass> getAllVeh() {

        List<VehClass> VehList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_Veh + " ORDER BY "+KEY_VEHMADE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                VehClass user = new VehClass();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setMade(cursor.getString(1));
                user.setModel(cursor.getString(2));
                user.setReg(cursor.getString(3));
                VehList.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return VehList;
    }

    public List<UsersClass> getAllUsers() {

        List<UsersClass> userList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+TABLE_Users + " ORDER BY "+KEY_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UsersClass user = new UsersClass();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return userList;
    }
}
