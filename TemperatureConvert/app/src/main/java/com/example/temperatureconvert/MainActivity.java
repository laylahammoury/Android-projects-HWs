package com.example.temperatureconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private Button convertBt;
    private TextView tempC;
    private EditText tempF;
    private Double tempInF;
    private Double tempInC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.convertBt= findViewById(R.id.Convertbt);
        this.tempC = findViewById(R.id.tempc);
        this.tempF = findViewById(R.id.tempF);

        this.convertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempInF = Double.parseDouble(tempF.getText().toString());
                tempInC = (tempInF - 32)/1.8;
                tempC.setText("" + tempInC);

            }
        });
    }
}
