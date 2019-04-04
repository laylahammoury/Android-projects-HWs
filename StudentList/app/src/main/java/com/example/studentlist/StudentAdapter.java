package com.example.studentlist;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {

    ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context ,0 ,students);
        this.students = students;

    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Student student = this.students.get(position);
    if(convertView == null)
    {
    convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_item_list , parent , false);
    }

        TextView name =convertView.findViewById(R.id.name);
        TextView id = convertView.findViewById(R.id.id);
        TextView major = convertView.findViewById(R.id.major);
//        CheckBox attendance = convertView.findViewById(R.id.attendance);
//        LinearLayout layout = convertView.findViewById(R.id.horizontalLayout);
        TextView avg = convertView.findViewById(R.id.avg);
        TextView DOB = convertView.findViewById(R.id.DOB);
        name.setText(student.getName());
        id.setText(student.getId()+"");
        avg.setText(student.getAvg()+"");
        DOB.setText(student.getDateOfBirth());
//        student.setAttendance(attendance.isChecked());
//        attendance.setChecked(attendance.isChecked());
//        boolean isHere = att.isChecked();

        major.setText(student.getMajor());
//        attendance.setChecked(student.isAttendance());
//        student.setAttendance(attendance.isChecked())  ;
//        if(attendance.isChecked())
        if(student.getAvg() >= 60 )
        {

            avg.setBackgroundColor(Color.parseColor("#b6eab6"));
        }
        else
            avg.setBackgroundColor(Color.parseColor("#f78c8c"));

        return convertView;

  /*      attendance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StudentAdapter.notifyDataSetChanged();
            }
        });
  */
        /*convertView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                                  }
                                              }

        );
*/
    }

}
