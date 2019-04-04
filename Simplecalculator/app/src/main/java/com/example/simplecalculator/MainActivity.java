package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double num1;
    private double num2;
    private double result;
    private Button plus;
    private Button minus;
    private Button divide;
    private Button multiply;
    private EditText data1;
    private EditText data2;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.plus = findViewById(R.id.plusbtn);
        this.minus = findViewById(R.id.minusbtn);
        this.divide = findViewById(R.id.divbtn);
        this.multiply = findViewById(R.id.multiplybtn);
        this.data1 = findViewById(R.id.num1);
        this.data2 = findViewById(R.id.num2);
        this.answer = findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                data1.equals("") || data2.equals("")
            if(data1.length()==0 || data2.length()==0)
                {
                    Toast.makeText(MainActivity.this, "You should enter numbers", Toast.LENGTH_SHORT).show();
                }
            else
                {
                    num1 = Double.parseDouble(data1.getText().toString());
                    num2 = Double.parseDouble(data2.getText().toString());
                    result = num1+ num2;
                    answer.setText(result+"");
                }

            }
        });//end of plus

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data1.length()==0 || data2.length()==0)
                {
                    Toast.makeText(MainActivity.this, "You should enter numbers", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    num1 = Double.parseDouble(data1.getText().toString());
                    num2 = Double.parseDouble(data2.getText().toString());
                    result = num1- num2;
                    answer.setText(result+"");
                }

            }
        });//end of minus

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data1.length()==0 || data2.length()==0)
                {
                    Toast.makeText(MainActivity.this, "You should enter numbers", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    num1 = Double.parseDouble(data1.getText().toString());
                    num2 = Double.parseDouble(data2.getText().toString());
                    result = num1/ num2;
                    answer.setText(result+"");
                }

            }
        });//end of divide

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data1.length()==0 || data2.length()==0)
                {
                    Toast.makeText(MainActivity.this, "You should enter numbers", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    num1 = Double.parseDouble(data1.getText().toString());
                    num2 = Double.parseDouble(data2.getText().toString());
                    result = num1* num2;
                    answer.setText(result+"");
                }

            }
        });
    }
}
