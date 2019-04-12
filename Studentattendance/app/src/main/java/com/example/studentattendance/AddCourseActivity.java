package com.example.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddCourseActivity extends AppCompatActivity {

    EditText courseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        courseName = findViewById(R.id.coursename);

    }
}
