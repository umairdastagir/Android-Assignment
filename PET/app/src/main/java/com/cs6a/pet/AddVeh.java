package com.cs6a.pet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVeh extends AppCompatActivity {

    DBClass db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_veh);

        final EditText edmade = findViewById(R.id.made);
        final EditText edregno = findViewById(R.id.regno);
        final EditText edmodel = findViewById(R.id.model);
        Button btnsub = findViewById(R.id.btnreg);
        db = new DBClass(this);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m = edmade.getText().toString();
                String mod = edmodel.getText().toString();
                String reg = edregno.getText().toString();
                if(m.isEmpty() || mod.isEmpty() || reg.isEmpty()){
                    Toast.makeText(getBaseContext(),"Please fill all of the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.insertVehDetails(m, reg, mod);
                    Toast.makeText(getBaseContext(),"Vehicle successfully added",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AddVeh.this, Main2Activity.class);
                    startActivity(i);
                    finishAffinity();
                }

            }
        });
    }
}
