package com.example.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseAdapter {

    SQLiteDatabase database;
    SqlHelper sqlHelper;
    String[] allColumns = {SqlHelper.COLUMN_ID, SqlHelper.COLUMN_TASK};
    String[] studentsColumns = {SqlHelper.COLUMN_ID, SqlHelper.COLUMN_NAME, SqlHelper.COLUMN_MAJOR, SqlHelper.COLUMN_GPA};

    public DatabaseAdapter(Context context){
        this.sqlHelper = new SqlHelper(context);
    }

    public void open(){
        this.database = this.sqlHelper.getWritableDatabase();
    }

    public void close(){
        this.database.close();
    }

    public void createTask(String task){
        ContentValues values = new ContentValues();
        values.put(SqlHelper.COLUMN_TASK, task);
        this.database.insert(SqlHelper.TABLE_TASKS, null, values);
    }

    public ArrayList<String> getAllTasks(){

        Cursor cursor = this.database.query(SqlHelper.TABLE_TASKS, allColumns, null, null, null, null, null);
        ArrayList<String> tasks = new ArrayList<String>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String task = cursor.getString(1);
            tasks.add(task);
            cursor.moveToNext();
        }

        cursor.close();
        return tasks;
    }


    public void addStudent(Student student){
        ContentValues values = new ContentValues();

        values.put(SqlHelper.COLUMN_NAME, student.getName());
        values.put(SqlHelper.COLUMN_MAJOR, student.getMajor());
        values.put(SqlHelper.COLUMN_GPA, student.getGPA());

        this.database.insert(SqlHelper.TABLE_STUDENTS, null, values);
    }

    public ArrayList<Student> getAllStudents(){
        Cursor cursor = this.database.query(SqlHelper.TABLE_STUDENTS, studentsColumns, null, null, null, null, null);
        ArrayList<Student> students = new ArrayList<Student>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String major = cursor.getString(2);
            double gpa = cursor.getDouble(3);

            Student student = new Student(Integer.parseInt(id), name, major, gpa);

            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }
}
