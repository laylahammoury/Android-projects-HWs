package com.example.datastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText name , address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.address = findViewById(R.id.address);
        this.name = findViewById(R.id.name);


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences myreference = getSharedPreferences("preferences" , 0);
        SharedPreferences.Editor editor  = myreference.edit();
            editor.putString("name" , this.name.getText().toString());
            editor.commit();
    String Filename = "addressFile";
    try{
        FileOutputStream fos = openFileOutput(Filename , Context.MODE_APPEND);
        fos.write(address.getText().toString().getBytes());
        fos.close();
    }
    catch(FileNotFoundException exception){
        exception.printStackTrace();
        }
        catch(IOException e)
        {e.printStackTrace();}

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("preferences"  , 0);
        if(preferences != null)
        {
            name.setText(preferences.getString("name" , "Enter name"));
        }

        try {
            FileInputStream fis = openFileInput("addressFile");
            InputStreamReader isr  = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer  sb = new StringBuffer();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);

            }
            address.setText(sb.toString());
        br.close();
            fis.close();
        }
        catch (FileNotFoundException e )
        {e.printStackTrace();}
        catch (IOException io)
        {io.printStackTrace();}


    }
}

