package com.example.listtry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String arr[]= {"Computer Science" , "Information Technology" , "Maths" , "Biology" , "Civil Engineer ","Computer Science" , "Information Technology" , "Maths" , "Biology" , "Civil Engineer "};
    private ListView list;
    private TextView t1;
    private TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.List);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this ,android.R.layout. simple_list_item_1 , arr);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t1.setText(arr[position]);
            }
        });


    }
}
