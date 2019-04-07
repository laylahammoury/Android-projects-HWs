package com.example.testdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydb";
    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASK = "task";
    public static final int VERSION = 3;
    public static final String CDATE = "cdate";
    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MAJOR = "major";
    public static final String COLUMN_GPA = "gpa";



    public static final String CREATE_TASKS = "CREATE TABLE " + TABLE_TASKS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            COLUMN_TASK + " text NOT NULL, " +
            CDATE + " text )";

    public static final String CREATE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            COLUMN_NAME + " text NOT NULL, " +
            COLUMN_MAJOR + " text NOT NULL, " +
            COLUMN_GPA  + " text NOT NULL )";

    public SqlHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TASKS);
        db.execSQL(CREATE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        this.onCreate(db);
    }
}
