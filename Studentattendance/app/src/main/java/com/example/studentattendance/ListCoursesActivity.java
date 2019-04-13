package com.example.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCoursesActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView coursesList;
    ArrayList<Courses> courses = new ArrayList<>();
    coursesAdapter coursesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_courses);

        this.coursesList = findViewById(R.id.coursesList);
        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        courses = databaseAdapter.getAllCourses();

        coursesAdapter = new coursesAdapter(this , courses);
        this.coursesList.setAdapter(coursesAdapter);
        databaseAdapter.close();


    }
}
