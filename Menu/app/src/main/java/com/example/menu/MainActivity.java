package com.example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item1) {
            this.text.setTextSize(10);
            this.text.setText("the text size is 10 points");
        }

        else if(item.getItemId() == R.id.item2)
        {
            this.text.setTextSize(14);
            this.text.setText("the text size is 14 points");

        }

        else if(item.getItemId() == R.id.item3){
            this.text.setTextSize(18);
            this.text.setText("the text size is 18 points");

        }

        else if(item.getItemId() == R.id.item4){
            this.text.setTextSize(24);
            this.text.setText("the text size is 24 points");

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu , menu);
        super.onCreateContextMenu(menu, v, menuInfo);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.text = findViewById(R.id.text);


    }
}
