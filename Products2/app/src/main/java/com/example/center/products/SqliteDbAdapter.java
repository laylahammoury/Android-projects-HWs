package com.example.center.products;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextMenu;

import java.util.ArrayList;

/**
 * Created by center on 10/31/2016.
 */
public class SqliteDbAdapter {
    SQLiteDatabase db;
    SqLiteHelper dbHelper;

    public SqliteDbAdapter(Context context){
        dbHelper = new SqLiteHelper(context);
    }
    public void open(){
        this.db = dbHelper.getWritableDatabase();
    }
    public void close(){
        this.db.close();
    }
    public long addProduct(Product p){
        open();
        long x = -1;
        ContentValues v= new ContentValues();
        if(!p.getName().equals("")) {
            v.put(dbHelper.COLUMN_NAME, p.getName());
            x = db.insert(dbHelper.TABLE_NAME, null, v);
        }
        close();
        return x;
    }
    public ArrayList<Product> getAll(){
        ArrayList<Product> ps = new ArrayList<>();
        open();
        Cursor c = db.query(dbHelper.TABLE_NAME, new String[]{dbHelper.COLUMN_ID, dbHelper.COLUMN_NAME}, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
           ps.add(new Product(c.getInt(0),c.getString(1)));
            c.moveToNext();
        }
        c.close();
        close();
        return ps;
    }

    public int deleteProduct(String name){
        open();
        int x=0;
        if(!name.equals(""))
            x = db.delete(SqLiteHelper.TABLE_NAME,SqLiteHelper.COLUMN_NAME + "=\"" + name + "\"",null);
        close();
        return x;
    }

    public int updateProduct(Product p){
        int x;
        open();
        ContentValues v = new ContentValues();
        v.put(SqLiteHelper.COLUMN_NAME,p.getName());
        x = db.update(SqLiteHelper.TABLE_NAME,v,SqLiteHelper.COLUMN_ID + "=" + p.getId(),null);
        close();
        return x;
    }

    public Product getProduct(String name){
        open();
        Product p = null;
        Cursor c = db.query(SqLiteHelper.TABLE_NAME,null,SqLiteHelper.COLUMN_NAME + "=\"" + name + "\""
                            ,null,null,null,null);
        if(c.getCount() != 0){
            c.moveToFirst();
            p = new Product(c.getInt(0),c.getString(1));
        }
        c.close();
        close();
        return p;
    }














//    public int deleteProduct(String name){
//        open();
//        int x = 0;
//        if(!name.equals(""))
//            x = db.delete(dbHelper.TABLE_NAME,dbHelper.COLUMN_NAME+ "= \"" + name + "\"" , null);
//        close();
//        return x;
//    }
//    public int updateProduct(Product p){
//        open();
//        ContentValues v = new ContentValues();
//        v.put(dbHelper.COLUMN_NAME,p.getName());
//        int x = db.update(dbHelper.TABLE_NAME,v,dbHelper.COLUMN_ID + "=" + p.getId(),null);
//        return x;
//
//    }
}
