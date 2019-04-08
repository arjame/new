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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public class EditRestaurantProfile extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private DatabaseReference reference;
    private TextView txt1,txt2,txt3,txt4;
    private Button savebutton;

    int i, j, k, l;
    boolean a,b,c,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurant_profile);

        txt1=(TextView) findViewById(R.id.txthourfrom);
        savebutton=(Button) findViewById(R.id.btnsave);
        reference=FirebaseDatabase.getInstance().getReference();
        Button btntimepicker1, btntimepicker2, btntimepicker3, btntimepicker4;
        final DialogFragment timepicker1, timepicker2, timepicker3, timepicker4;
        a=b=c=d=false;
        timepicker1 = timepicker2 = timepicker3 = timepicker4 = new TimePicker();
        btntimepicker1 = findViewById(R.id.btntimepicker1);
        btntimepicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker1.show(getSupportFragmentManager(), "timepicker");
                a=true;

            }
        });
        btntimepicker2 = findViewById(R.id.btntimepicker2);
        btntimepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  a=false;
                b=true;
                timepicker2.show(getSupportFragmentManager(), "timepicker");
            }
        });
        btntimepicker3 = findViewById(R.id.btntimepicker3);
        btntimepicker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { a=false;b=false; c=true;
                timepicker3.show(getSupportFragmentManager(), "timepicker");
            }
        });
        btntimepicker4 = findViewById(R.id.btntimepicker4);
        btntimepicker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { a=false;b=false;c=false;d=true;
                timepicker4.show(getSupportFragmentManager(), "timepicker");
            }
        });
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==savebutton) {
                    storeuserinf();
                }
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
    public void onTimeSet (android.widget.TimePicker View,int hourOfDay, int minute){
        i = hourOfDay;
        j = minute;
        TextView textView1 = (TextView) findViewById(R.id.txthourfrom);
        TextView textView2 =(TextView) findViewById(R.id.txthourto);
        TextView textView3=(TextView) findViewById(R.id.txthourfrom2);
        TextView textView4=(TextView) findViewById(R.id.txthourto2);
        if (a==true){
            textView1.setText("From:  "+'\n'+ hourOfDay+":" + minute);

        }   else if (b==true){
            textView2.setText(" To  " +'\n'+ hourOfDay+":" + minute);
        }     else if (c==true) {
            textView3.setText("From:  "+'\n'+ hourOfDay+":" + minute);
        }else if (d==true){
            textView4.setText("To:  "+'\n'+ hourOfDay+":" + minute);
        }
        else return;
    }
    private void  storeuserinf()
    {
        String hour=txt1.getText().toString().trim();
        saveinformation saveinformation=new saveinformation(hour);
        reference.child("child").setValue(saveinformation);
        Toast.makeText(this,hour,Toast.LENGTH_SHORT).show();


    }


}


