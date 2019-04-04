package com.example.laylamidtermlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView counter,best;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.counter = findViewById(R.id.counter);
        this.best = findViewById(R.id.best);
//        int size;
//        if (Main2Activity.s.isEmpty() )
//            size = 0;
//        else
//            size =Main2Activity.s.size();
        counter.setText("# of students: "+Main2Activity.count);
//        double
        best.setText("Student with highest gpa: "+Main2Activity.maxname);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.addStudent) {
            Intent intent = new Intent(getApplicationContext() , Main2Activity.class);
            startActivity(intent);

        }

        else if(item.getItemId() == R.id.studentList)
        {
            Intent intent = new Intent(getApplicationContext() , Main3Activity.class);
            startActivity(intent);

        }



        return super.onOptionsItemSelected(item);
    }


}
