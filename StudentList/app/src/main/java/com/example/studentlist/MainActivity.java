package com.example.studentlist;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public  ArrayList<Student> s;
    Student s1, s2,s3,s4,s5;
    ListView list;
    CheckBox att;
    EditText name;
    EditText id;
    EditText major;
    EditText avg;
    Button date;
    Button save;

    String Name;
    int ID;
    String Major;
    String DOB="";
    double Avg;
    boolean Att;

    DateFormat format  = java.text.DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d;
    Calendar myCal = Calendar.getInstance();

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu , menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit)
        {
            Toast.makeText(this, "Try the edit", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.list = findViewById(R.id.list);
        this.att = findViewById(R.id.enterAtt);
        this.name = findViewById(R.id.enterName);
        this.id = findViewById(R.id.enterId);
        this.major = findViewById(R.id.enterMajor);
        this.avg = findViewById(R.id.enterAvg);
        this.date = findViewById(R.id.dateBtn);
        this.save = findViewById(R.id.saveBtn);
        this.s =new ArrayList<Student>();


        registerForContextMenu(list);

      /*   s1 =new Student("Ali" , 178017 , "Computer Science" , true , 90.2);
         s2 =new Student("Layla" , 15835 , "Maths" , true , 50.4);
         s3 =new Student("Ezdehar" , 178017 , "Information Technology" , false , 75);
         s4 =new Student("Islam" , 178017 , "Biology" , true , 89.9);
         s5 =new Student("Bara'a" , 178017 , "Civil Engineering" , false , 68.8);
*/
        final StudentAdapter adapter = new StudentAdapter(this , s);
        this.list.setAdapter(adapter);

        d= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
                myCal.set(Calendar.YEAR , year);
                myCal.set(Calendar.MONTH , month);
                myCal.set(Calendar.DAY_OF_MONTH , dayOfMonth);
                DOB = format.format(myCal.getTime());
            }
        };
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(id.length() == 0 ||name.length() == 0 || major.length() == 0 || avg.length() == 0)
                {
                    Toast.makeText(MainActivity.this, "You Should enter all the information", Toast.LENGTH_SHORT).show();

                }
                if (DOB.length() == 0)
                {
                    Toast.makeText(MainActivity.this, "You Should enter date of birth", Toast.LENGTH_SHORT).show();

                }
                else{
                    Student s0;
                    Name = name.getText().toString();
                    ID = Integer.parseInt(id.getText().toString());
                    Major = major.getText().toString();
                    Avg = Double.parseDouble(avg.getText().toString());
                    Att = att.isChecked();

                    s0 = new Student (Name , ID , Major , Att , Avg , DOB);
                    s.add(s0);
                    adapter.notifyDataSetChanged();

                    name.setText("");
                    id.setText("");
                    major.setText("");
                    avg.setText("");
                    att.setChecked(false);
                }

//                adapter.add(s0);


            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this ,d,
                        myCal.get(Calendar.YEAR) , myCal.get(Calendar.MONTH) , myCal.get(Calendar.DAY_OF_MONTH) ).show();
            }
        });





    }
}
