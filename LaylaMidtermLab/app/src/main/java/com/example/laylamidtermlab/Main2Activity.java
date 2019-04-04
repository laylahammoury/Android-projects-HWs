package com.example.laylamidtermlab;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    private String d;
    public static int count = 0;
    private EditText entername , enternumber , entergpa;
    private TextView date;
    private Button enterdate , addstudentbtn , backbtn;
    private boolean male;
    public  static ArrayList<Student> s;
    static double max = 0;
    static String maxname = "";
    RadioGroup genderRadio;
    RadioButton maleRadio , femaleRadio;
    DateFormat format =java.text.DateFormat.getDateInstance();
    final Calendar mycal = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datelistener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.entername = findViewById(R.id.entername);
        this.enternumber = findViewById(R.id.enternumber);
        this.entergpa = findViewById(R.id.entergpa);
        this.date = findViewById(R.id.date);
        this.enterdate = findViewById(R.id.enterdate);
        this.addstudentbtn = findViewById(R.id.addStudentbtn);
        this.backbtn = findViewById(R.id.backbtn);
        this.maleRadio = findViewById(R.id.maleradio);
        this.femaleRadio = findViewById(R.id.femaleradio);
        this.s =new ArrayList<Student>();


        datelistener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar.getInstance().set(i , i1 , i2);
                d =format.format(mycal.getTime());
            }
        };

        enterdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Main2Activity.this , datelistener ,
                        mycal.get(Calendar.YEAR) ,
                        mycal.get(Calendar.MONTH) ,
                        mycal.get(Calendar.DAY_OF_MONTH)
                ).show();
                date.setText(d);

            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
            }
        });
        addstudentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (maleRadio.isChecked())
                    male = true;
                else male = false;

                int phone = Integer.parseInt(enternumber.getText().toString());

                double gpa = Double.parseDouble(entergpa.getText().toString());
                if (gpa > max) {
                    max = gpa;
                    maxname = entername.getText().toString();
                }
                if (enternumber.length() == 0 || enternumber.length() == 0 || entergpa.length() == 0) {
                    Toast.makeText(Main2Activity.this, "You Should enter all the information", Toast.LENGTH_SHORT).show();

                }
                if (d.length() == 0) {
                    Toast.makeText(Main2Activity.this, "You Should enter date of birth", Toast.LENGTH_SHORT).show();

                } else {
                    Student s0;
                    s0 = new Student(entername.getText().toString(), d, gpa, phone, male);
                    s.add(s0);
                    Toast.makeText(Main2Activity.this, "student " + entername.getText().toString() + " added", Toast.LENGTH_SHORT).show();
                    count++;
                    entername.setText("");
                    entergpa.setText("");
                    enternumber.setText("");
                    maleRadio.setChecked(false);
                    femaleRadio.setChecked(false);

                }
            }
        });
    }
}
