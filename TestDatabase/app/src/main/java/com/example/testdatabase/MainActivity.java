package com.example.testdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText task;
    Button addTask;
    TextView taskstext;
    DatabaseAdapter databaseAdapter;
    ArrayList<String> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.task = findViewById(R.id.task);
        this.addTask = findViewById(R.id.addTask);
        this.taskstext = findViewById(R.id.taskstext);

        this.databaseAdapter = new DatabaseAdapter(this);

        this.addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseAdapter.open();
                databaseAdapter.createTask(task.getText().toString());

                tasks = databaseAdapter.getAllTasks();
                String alltasks = "";
                for (String task: tasks){
                    alltasks += ", " +  task;
                }
                taskstext.setText(alltasks);
                databaseAdapter.close();
            }
        });


    }
}
