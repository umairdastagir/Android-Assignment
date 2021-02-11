package com.cs6a.pet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigInteger;

public class Register extends AppCompatActivity {

    EditText inputText,keyText;
    TextView tOut;
    Button btn;

    String newString,inputString;
    int key;


    DBClass mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText user = findViewById(R.id.user);
        final EditText pass = findViewById(R.id.pass);
        final EditText cnfrm = findViewById(R.id.cnfrmp);
        final Button btnreghash = findViewById(R.id.btnreghash);
        final Button btnexit = findViewById(R.id.btnexit);
        btnexit.setVisibility(View.INVISIBLE);
        final TextView txtpass = findViewById(R.id.txtencrypted);
        mydb = new DBClass(this);


        btnreghash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = user.getText().toString();
                String p = pass.getText().toString();
                String c = cnfrm.getText().toString();
               if(u.isEmpty() || p.isEmpty() || c.isEmpty()){
                   Toast.makeText(getBaseContext(),"Please fill all of the fields",Toast.LENGTH_SHORT).show();
               }
               else if(p.matches(c)){
                   byte[] inputData = c.getBytes();
                   byte[] outputData = new byte[0];

                   try {
                       outputData = Sha.encryptSHA(inputData, "SHA-1");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }

                   BigInteger shaData = new BigInteger(1, outputData);
                   String encpass = shaData.toString(16);
                   txtpass.setText(encpass);
                   mydb.insertUserDetails(u,encpass);
                   Toast.makeText(getBaseContext(),"User successfully registered",Toast.LENGTH_SHORT).show();
                   btnexit.setVisibility(View.VISIBLE);
                   btnreghash.setVisibility(View.INVISIBLE);
               }
                else{
                   Toast.makeText(getBaseContext(),"Passwords don't match",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,MainScreen.class));
                finishAffinity();
            }
        });

    }

}
