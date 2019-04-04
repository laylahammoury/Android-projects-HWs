package com.example.studentattendance;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {
    SQLiteDatabase database;
    SqLiteHelper sqlHelper;

    public void ADDSTUDENT(Students stu){
        ContentValues values  = new ContentValues();
        values.put(SqLiteHelper.STUDENT_NAME , stu.getStudent_name());
        values.put(SqLiteHelper.STUDENT_NAME , stu.getStudent_name());
        values.put(SqLiteHelper.STUDENT_NAME , stu.getStudent_name());
//bla bla bla
        this.database.insert(SqLiteHelper.STUDENT_TABLE ,null ,values  );

    }
}
