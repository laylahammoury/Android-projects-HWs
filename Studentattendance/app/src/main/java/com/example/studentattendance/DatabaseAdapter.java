package com.example.studentattendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseAdapter {
    SQLiteDatabase database;
    SqLiteHelper sqlHelper;
    //all columns
    String[] StudentsColumns = {SqLiteHelper.STUDENT_ID, SqLiteHelper.STUDENT_NAME};
    String [] CoursesColumns = {SqLiteHelper.COURSE_ID ,SqLiteHelper.COURSE_NAME };
    String [] EnrollmentColumns = {SqLiteHelper.COURSE_ID, SqLiteHelper.STUDENT_ID};
    String [] LectureColumns = {SqLiteHelper.COURSE_ID ,SqLiteHelper.LECTURE_ID,SqLiteHelper.LECTURE_DATE};
    String [] AttendColumns = {SqLiteHelper.STUDENT_ID,SqLiteHelper.COURSE_ID ,SqLiteHelper.LECTURE_ID,
            SqLiteHelper.ATTEND_NOTE ,SqLiteHelper.ATTEND_ATTENDANCE};

    public DatabaseAdapter(Context context){
        this.sqlHelper = new SqLiteHelper(context);
    }

    public void open(){
        this.database = this.sqlHelper.getWritableDatabase();
    }

    public void close(){
        this.database.close();
    }

    public void addStudent(Students student){
        ContentValues values = new ContentValues();

        values.put(SqLiteHelper.STUDENT_NAME, student.getStudent_name());
        values.put(SqLiteHelper.STUDENT_ID, student.getStudent_id());

        this.database.insert(SqLiteHelper.STUDENT_TABLE, null, values);
    }

    public ArrayList<Students> getAllStudents(){
        Cursor cursor = this.database.query(SqLiteHelper.STUDENT_TABLE, StudentsColumns, null, null,
                null, null, null);
        ArrayList<Students> students = new ArrayList<Students>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);

            Students student = new Students(Integer.parseInt(id), name);

            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    public void addCourses(Courses course){
        ContentValues values = new ContentValues();

        values.put(SqLiteHelper.COURSE_ID, course.getCourse_id());
        values.put(SqLiteHelper.COURSE_NAME, course.getCourse_name());

        this.database.insert(SqLiteHelper.COURSE_TABLE, null, values);
    }

    public ArrayList<Courses> getAllCourses(){
        Cursor cursor = this.database.query(SqLiteHelper.COURSE_TABLE,CoursesColumns, null, null,
                null, null, null);
        ArrayList<Courses> courses = new ArrayList<Courses>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);

            Courses course = new Courses(Integer.parseInt(id), name);

            courses.add(course);
            cursor.moveToNext();
        }

        cursor.close();
        return courses;
    }
}
