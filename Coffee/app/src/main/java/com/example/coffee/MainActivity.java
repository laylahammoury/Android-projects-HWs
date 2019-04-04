package com.example.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox Sugar;
    private CheckBox Cream;
    private Button Paybtn;
    private RadioGroup radioType;
    private RadioButton colombian;
    private RadioButton decaf;
    private RadioButton expresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Paybtn = findViewById(R.id.payBtn);
        this.Sugar = findViewById(R.id.sugarchk);
        this.Cream= findViewById(R.id.creamchk);
        this.Paybtn = findViewById(R.id.payBtn);
        this.radioType = findViewById(R.id.radioGroup);
        this.expresso = findViewById(R.id.expresso);
        this.decaf = findViewById(R.id.decaf);
        this.colombian = findViewById(R.id.colombian);

        Paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ctype  = "";
                if(expresso.isChecked())
                {
                    ctype = "Expresso";
                }
                if(colombian.isChecked())
                {
                    ctype = "Colombian";
                }
                if(decaf.isChecked())
                {
                    ctype = "Decaf";
                }

                String s  = "Coffee";
                if(Sugar.isChecked())
                    s+=" & Sugar";
                if(Cream.isChecked())
                    s+=" & Cream";
                Toast.makeText(MainActivity.this, ctype + " " + s, Toast.LENGTH_SHORT).show();

            }

        });

    }
}
