package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      
        Log.d("cycle","OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Cylce", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Cycle", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Cycle", "OnDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Cycle", "OnPause");

    }
}
