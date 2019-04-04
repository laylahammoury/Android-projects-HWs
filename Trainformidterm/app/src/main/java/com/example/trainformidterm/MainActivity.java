package com.example.trainformidterm;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView t1 ,t2 ;
    private ListView list;
    public TextView date , time;
    private String d;
    private Button b1,b2,move ,check;
    private EditText friend;
    DateFormat format =java.text.DateFormat.getDateInstance();
    final Calendar mycal = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener datelistener;
    TimePickerDialog.OnTimeSetListener timeSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.b1 = findViewById(R.id.b1);
        this.b2 = findViewById(R.id.b2);
        this.move = findViewById(R.id.move1btn);
        this.check = findViewById(R.id.check);
        this.t1 = findViewById(R.id.conmen);
        this.t2 = findViewById(R.id.listtext);
        this.date = findViewById(R.id.date);
        this.time = findViewById(R.id.time);
        this.friend = findViewById(R.id.certainText);
        list = findViewById(R.id.list);
        this.registerForContextMenu(t1);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Wrong Friend Name");
                dialog.setMessage("You should enter a different bane than yours");
                dialog.setPositiveButton("Yes",  new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,  int whichbutton) {

                }});
                dialog.setNegativeButton("No",  new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,  int whichbutton) {

                }});
                dialog.setNeutralButton("no problem",  new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog,  int whichbutton) {

                }});
                    dialog.create();
                    dialog.show();

            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Main2Activity.class);
                startActivity(intent);

            }
        });
        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    mycal.set(Calendar.HOUR , i) ;
                    mycal.set(Calendar.MINUTE , i1);
                    time.setText(i + ":" + i1);
            }
        };

        datelistener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar.getInstance().set(i , i1 , i2);
                d =format.format(mycal.getTime());
                date.setText(d);
            }
        };
        final String arr[] = {"value1" ,"value2" , "value3"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , arr);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t2.setText(arr[position]);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this , datelistener ,
                        mycal.get(Calendar.YEAR) ,
                        mycal.get(Calendar.MONTH) ,
                        mycal.get(Calendar.DAY_OF_MONTH)
                        ).show();


            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(MainActivity.this ,timeSetListener ,
                        mycal.get(Calendar.HOUR) , mycal.get(Calendar.MINUTE) , false).show();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu , menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.context1)
        {
            this.t1.setText(t1.getText().toString() + "first");

        }else
        if (item.getItemId() == R.id.context2)
        {
            this.t1.setText( "second");

        }else
        if (item.getItemId() == R.id.context3)
        {
            this.t1.setText("third");

        }
        return super.onContextItemSelected(item);

    }
}
