package com.example.laylamidtermlab;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        list = findViewById(R.id.list);
        final ArrayList<Student>  st= Main2Activity.s;
        final studentAdapter adapter = new studentAdapter(this , st);
        this.list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                String write;
                String gen;
                if(st.get(i).isMale())
                     gen = "Male";
                else
                    gen="Female";

                write = "Name: " + st.get(i).getName()+"\n"
                        +"GPA:" + st.get(i).getAvg() + "\n"
                        +"BIRTHDATE:" + st.get(i).getDateOfBirth() + "\n"
                        + "Gender:" + gen;
                AlertDialog.Builder dialog = new AlertDialog.Builder(Main3Activity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("Student info");

                dialog.setMessage(write);

                dialog.setNegativeButton("OK",  new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,  int whichbutton) {

                    }});
                dialog.setNeutralButton("CALL",  new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,  int whichbutton) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ st.get(i).getPhone()) );                        startActivity(intent);
                    }});
                dialog.create();
                dialog.show();

            }
        });
    }
}
