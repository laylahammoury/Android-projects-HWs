package com.example.laylamidtermlab;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class studentAdapter extends ArrayAdapter<Student> {
    ArrayList<Student> students;
    public studentAdapter(Context context, ArrayList<Student> students) {
        super(context ,0 ,students);
        this.students = students;

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = this.students.get(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_list , parent , false);
        }

        TextView name =convertView.findViewById(R.id.namelist);
        TextView avg = convertView.findViewById(R.id.gpalist);
        TextView DOB = convertView.findViewById(R.id.date);
//        TextView gender = convertView.findViewById(R.id.genderradio);
        name.setText("Student Name:"+student.getName());
        avg.setText("GPA:"+student.getAvg());
//        avg.setText("try");
//        DOB.setText(student.getDateOfBirth());

        if(student.getAvg() >= 60 )
        {

            avg.setTextColor(Color.parseColor("#b6eab6"));
        }
        else
            avg.setTextColor(Color.parseColor("#f78c8c"));

        return convertView;


    }
}
