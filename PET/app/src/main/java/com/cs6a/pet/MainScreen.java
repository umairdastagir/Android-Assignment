package com.cs6a.pet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;


public class MainScreen extends AppCompatActivity {

    DBClass mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mydb = new DBClass(this);
        final EditText edtuser =  findViewById(R.id.edittext);
        final EditText edtpass =  findViewById(R.id.edittext2);
        Button btn =  findViewById(R.id.login);
        Button btnreg = findViewById(R.id.register);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainScreen.this, Register.class);
                startActivity(i);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mydb.getReadableDatabase();

               if(edtuser.getText().toString().trim().isEmpty() || edtpass.getText().toString().trim().isEmpty()){
                   Toast.makeText(getBaseContext(),"Make sure you have entered both username and password", Toast.LENGTH_SHORT).show();
               }
                else{
                   byte[] inputData = edtpass.getText().toString().getBytes();
                   byte[] outputData = new byte[0];

                   try {
                       outputData = Sha.encryptSHA(inputData, "SHA-1");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }

                   BigInteger shaData = new BigInteger(1, outputData);
                   String encpass = shaData.toString(16);
                   Cursor c = db.rawQuery("SELECT * FROM userdetails WHERE name='" + edtuser.getText().toString().trim() + "'" + "AND password='"+encpass+"'", null);
                   if (c.moveToFirst()) {
                       Intent intent = new Intent(MainScreen.this, Main2Activity.class);
                       startActivity(intent);
                   } else {

                       Toast.makeText(getBaseContext(),"User doesn't exist", Toast.LENGTH_LONG).show();
                   }
                }
            }
        });
    }
}
