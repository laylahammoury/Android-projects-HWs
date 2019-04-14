package com.example.studentattendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCoursesActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    ListView coursesList;
    ArrayList<Courses> courses = new ArrayList<>();
    coursesAdapter coursesAdapter;
    int course_pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_courses);
        registerForContextMenu(coursesList);

        this.coursesList = findViewById(R.id.coursesList);
        this.databaseAdapter = new DatabaseAdapter(this);

        databaseAdapter.open();
        courses = databaseAdapter.getAllCourses();

        coursesAdapter = new coursesAdapter(this , courses);
        this.coursesList.setAdapter(coursesAdapter);
        databaseAdapter.close();

        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 course_pos=position;

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info=  (AdapterView.AdapterContextMenuInfo)menuInfo;
        if(v.getId()==R.id.coursesList)
            getMenuInflater().inflate(R.menu.courses_menue,menu);


    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.item1:{


                break;}
            case R.id.item2:

                break;
            case R.id.item3:
                courses.remove(course_pos);
                break;
        }

        return super.onContextItemSelected(item);
    }

}
