package com.example.center.products;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText prod_name;
    Button add_btn,delete_btn,update_btn;
    TextView id_text,name_text;
    SqliteDbAdapter dba;
    ArrayList<Product> arr;
    TextView res;
    View newView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView)findViewById(R.id.res);
        arr = new ArrayList<>();


        dba = new SqliteDbAdapter(this);
        prod_name = (EditText)findViewById(R.id.prod_name);
        add_btn = (Button)findViewById(R.id.add_btn);
        delete_btn = (Button)findViewById(R.id.delete_btn);
        update_btn = (Button)findViewById(R.id.update_btn);
        id_text = (TextView)findViewById(R.id.id_text);
        name_text = (TextView)findViewById(R.id.name_text);
        display();
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dba.addProduct(new Product(prod_name.getText().toString())) != -1)
                    Toast.makeText(MainActivity.this, "product added", Toast.LENGTH_SHORT).show();
                prod_name.setText("");
                display();
            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dba.deleteProduct(prod_name.getText().toString())!=0)
                    Toast.makeText(MainActivity.this, "product deleted", Toast.LENGTH_SHORT).show();
                prod_name.setText("");
                display();
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle("update product");

                LayoutInflater inflater = getLayoutInflater();
                newView = inflater.inflate(R.layout.dialog_layout,null);
                dialog.setView(newView);

                dialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText update_name = (EditText)newView.findViewById(R.id.update_name);
                        EditText update_id = (EditText)newView.findViewById(R.id.update_id);
                        String name = update_name.getText().toString();
                        int id = Integer.parseInt(update_id.getText().toString());
                        Product p = new Product(id,name);
                        if(dba.updateProduct(p)!=0)
                            Toast.makeText(MainActivity.this, "Product updated", Toast.LENGTH_SHORT).show();
                        display();
                    }
                });
                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
        prod_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("")) {
                    Product p = dba.getProduct(s.toString());
                    if (p == null)
                        res.setText("No product found");
                    else
                        res.setText("Name: " + p.getName() + "\nID: " + p.getId());
                }
            }
        });
    }
    public void display(){
        String ids = "id\n---";
        String names = "product name\n------------------------";
        arr = dba.getAll();
        for(int i=0;i<arr.size();i++){
            ids += "\n" + arr.get(i).getId();
            names += "\n" + arr.get(i).getName();
       }
        id_text.setText(ids);
        name_text.setText(names);

    }


}
