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
}
