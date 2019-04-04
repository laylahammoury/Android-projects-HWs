package com.example.insurancecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup agegroup;
    private RadioGroup gendergroup;
    private RadioButton age1;
    private RadioButton age2;
    private RadioButton age3;
    private RadioButton age4;
    private RadioButton male;
    private RadioButton female;
    private CheckBox accident;
    private CheckBox speed;
    private TextView result ;
    private Double insurance = 1000.0;
    private Double initial = 1000.0;
    private Button calcBtn;
    private Button clearBtn;
    private boolean age=false;
    private boolean gender=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agegroup = findViewById(R.id.ageGroup);
        gendergroup = findViewById(R.id.genderGroup);
        age1 = findViewById(R.id.firstAge);
        age2 = findViewById(R.id.secondAge);
        age3 = findViewById(R.id.thirdAge);
        age4 = findViewById(R.id.forthAge);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        accident = findViewById(R.id.accident);
        speed = findViewById(R.id.speed);
        result = findViewById(R.id.result);
        calcBtn = findViewById(R.id.calculateBtn);
        clearBtn = findViewById(R.id.cleatBtn);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insurance= initial;
                result.setText("");
                gendergroup.clearCheck();
                agegroup.clearCheck();
                accident.setChecked(false);
                speed.setChecked(false);
            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if( age1.isChecked())
            {
                insurance += initial * 0.5;
                age=true;
            }
                else {
                    if( age2.isChecked())
                    {
                        insurance += initial * 0.3;
                        age=true;
                    }else {
                        if( age3.isChecked())
                        {
                            insurance += initial * 0.2;
                            age=true;
                        }else {
                            if( age4.isChecked())
                            {
                                insurance += initial * 0.35;
                                age=true;
                            }
                        }
                    }

            }

                if( female.isChecked())
                {
                    insurance += initial * 0.1;
                    gender=true;
                }else {
                    if( male.isChecked())
                    {
                        insurance += initial * 0.05;
                        gender= true;
                    }
                }
                if(accident.isChecked())
                    insurance+= initial*0.25;
                if(speed.isChecked())
                    insurance+= initial*0.1;
                if(age && gender )
                {
                    if(result.length()==0)
                    result.setText("" + insurance);
                    else
                        Toast.makeText(MainActivity.this, "Click CLEAR Before calculating again", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Enter age AND Gender", Toast.LENGTH_SHORT).show();
                }
            }//onclick function

        });

    }


}
