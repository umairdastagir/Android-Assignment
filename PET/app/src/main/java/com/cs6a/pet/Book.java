package com.cs6a.pet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class Book extends AppCompatActivity {

    EditText inputText,keyText,keyDText;
    TextView tOut,tdOut;
    Button btn,btnd;

    String newString,inputString;
    int key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        inputText = findViewById(R.id.edtin);
        keyText = findViewById(R.id.edtcaesar);
        keyDText = findViewById(R.id.edtdcaesar);
        tOut = findViewById(R.id.tvout);
        tdOut = findViewById(R.id.tvdout);
        btn = findViewById(R.id.btncsr);
        btnd = findViewById(R.id.btndcsr);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String csrkey = keyText.getText().toString();
                inputString = inputText.getText().toString();
                if (! TextUtils.isEmpty(csrkey)){
                    key = Integer.parseInt(csrkey);
                    newString = encryptCaesar(inputString, key);
                    tOut.setText(newString);
                }
                else{
                    Toast.makeText(getBaseContext(),"Please give a key for encryption",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String csrkey = keyDText.getText().toString();
                inputString = tOut.getText().toString();
                if(! TextUtils.isEmpty(csrkey)){
                    if(! TextUtils.isEmpty(inputString)){
                        key = Integer.parseInt(csrkey);
                        newString = decrypter(inputString, key);
                        tdOut.setText(newString);
                    }
                    else{
                        Toast.makeText(getBaseContext(),"Please encrypt something first",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getBaseContext(),"Please give a key for encryption",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //  TODO: SHA-1,SHA-224,SHA-256,SHA-384,SHA-512

    public void btnSHA(View v){
        EditText edtin = findViewById(R.id.edtin);
        TextView txtout = findViewById(R.id.tvout);

        RadioGroup rg = findViewById(R.id.rg);
        int check = rg.getCheckedRadioButtonId();
        RadioButton rb = findViewById(check);

        byte[] inputData = edtin.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = Sha.encryptSHA(inputData, rb.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigInteger shaData = new BigInteger(1, outputData);
        txtout.setText(shaData.toString(16));
    }

    protected String encryptCaesar(String inputString, int key){
        StringBuffer output;
        Character charac;
        int pAscii,nAscii;
        output = new StringBuffer();

        for(int i=0;i<inputString.length();i++){
            charac = inputString.charAt(i);
            if(charac.equals(' ')){
                output.append(charac);
                continue;
            }
            pAscii = (int)charac;
            nAscii = pAscii + key;
            if(nAscii > 90 && Character.isUpperCase(charac) || nAscii > 122){
                nAscii -= 26;
            }
            output.append((char)nAscii);
        }
        return String.valueOf(output);

    }

    protected String decrypter(String inputString, int key){
        StringBuffer output;
        Character charac;
        int pAscii,nAscii;
        output = new StringBuffer();

        for(int i=0;i<inputString.length();i++){
            charac = inputString.charAt(i);
            if(charac.equals(' ')){
                output.append(charac);
                continue;
            }
            pAscii = (int)charac;
            nAscii = pAscii - key;
            if(nAscii < 65 && Character.isUpperCase(charac) || nAscii < 97){
                nAscii += 26;
            }
            output.append((char)nAscii);
        }
        return String.valueOf(output);
    }
}
