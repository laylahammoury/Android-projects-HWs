package com.example.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddCourseActivity extends AppCompatActivity {

    EditText coursename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        coursename = findViewById(R.id.coursename);

    }
}
