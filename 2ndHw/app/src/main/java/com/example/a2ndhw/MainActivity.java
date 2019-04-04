package com.example.a2ndhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText shekel;
    private Button convert;
    private TextView dollar;
    private TextView euro;
    private double Inshekel;
    private double Indollar;
    private double Ineuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.shekel = findViewById(R.id.shekel);
        this.dollar = findViewById(R.id.dollar);
        this.convert = findViewById(R.id.convertBt);
        this.euro = findViewById(R.id.euro);

        this.convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inshekel = Double.parseDouble( shekel.getText().toString());
                Indollar =0.2747252747252747 * Inshekel;
                Ineuro = Inshekel /4.166666666666667;
                String s = getResources().getString(R.string.Ineuro);

                dollar.setText("In Dollar :" + Indollar);
                euro.setText(s+ Ineuro);


            }
        });


    }
}
