package com.example.lab2firebase;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditRestaurantProfile extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    TextView textView1, textView2, textView3, textView4;
    int i, j, k, l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurant_profile);
        Button btntimepicker1, btntimepicker2, btntimepicker3, btntimepicker4;
        final DialogFragment timepicker1, timepicker2, timepicker3, timepicker4;
        timepicker1 = timepicker2 = timepicker3 = timepicker4 = new TimePicker();
        btntimepicker1 = findViewById(R.id.btntimepicker1);
        btntimepicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker1.show(getSupportFragmentManager(), "timepicker");

            }
        });
        btntimepicker2 = findViewById(R.id.btntimepicker2);
        btntimepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker2.show(getSupportFragmentManager(), "timepicker");
            }
        });
        btntimepicker3 = findViewById(R.id.btntimepicker3);
        btntimepicker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker3.show(getSupportFragmentManager(), "timepicker");
            }
        });
        btntimepicker4 = findViewById(R.id.btntimepicker4);
        btntimepicker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker4.show(getSupportFragmentManager(), "timepicker");
            }
        });
        //*********Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //end of toolbar
        // Write  to the database

    }

    //********** what toolbar is doing
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.backmenu_black, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_back) {
            Intent intent = new Intent(this, RestaurantProfile.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    //End of code related to the toolbar
    @Override
    public void onTimeSet(android.widget.TimePicker View, int hourOfDay, int minute) {
        i = hourOfDay;
        j = minute;
        textView1 = findViewById(R.id.txthourfrom);
        textView1.setText("From" + i + ":" + j);
    }


}