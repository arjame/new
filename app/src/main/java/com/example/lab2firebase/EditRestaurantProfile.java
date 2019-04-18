package com.example.lab2firebase;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditRestaurantProfile extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, AdapterView.OnItemSelectedListener {
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    private DatabaseReference reference=database.getReference("Resturants");
    //saving hours variables
    private TextView txt1,txt2,txt3,txt4;
    //saving name phone mobile address
    private TextView txt5,txt6,txt7,txt8;
//saving totall info
    private TextView txt9,txt10,txt11,txt12,txt13,txt14,txt15;
    private Button savebutton;
    private String day;
    boolean a,b,c,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurant_profile);
        Spinner weekdays=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.weekdays,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        weekdays.setAdapter(adapter);
        weekdays.setOnItemSelectedListener(this);




        txt1=(TextView) findViewById(R.id.txthourfrom);
        txt2=(TextView)findViewById(R.id.txthourto);
        txt3=(TextView)findViewById(R.id.txthourfrom2);
        txt4=(TextView)findViewById(R.id.txthourto2);
        txt5=(TextView)findViewById(R.id.edt_nameRestaurant);
        txt6=(TextView)findViewById(R.id.edt_phoneRestaurant);
        txt7=(TextView)findViewById(R.id.edt_mobileresturant);
        txt8=(TextView)findViewById(R.id.edt_address);
        txt9=(TextView) findViewById(R.id.txt_monday);
        txt10=(TextView) findViewById(R.id.txt_tuesday);
        txt11=(TextView) findViewById(R.id.txt_wednesday);
        txt12=(TextView) findViewById(R.id.txt_thursday);
        txt13=(TextView) findViewById(R.id.txt_friday);
        txt14=(TextView) findViewById(R.id.txt_saturday);
        txt15=(TextView) findViewById(R.id.txt_sunday);

        savebutton=(Button) findViewById(R.id.btnsave);
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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                    storeuserinf();
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
        TextView textView1 = (TextView) findViewById(R.id.txthourfrom);
        TextView textView2 =(TextView) findViewById(R.id.txthourto);
        TextView textView3=(TextView) findViewById(R.id.txthourfrom2);
        TextView textView4=(TextView) findViewById(R.id.txthourto2);
        if (a==true){
            textView1.setText(""+ hourOfDay+":" + minute);

        }   else if (b==true){

            textView2.setText(""+ hourOfDay+":" + minute);
        }     else if (c==true) {

            textView3.setText(""+ hourOfDay+":" + minute);
        }else if (d==true){

            textView4.setText(""+ hourOfDay+":" + minute);
        }
        else return;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void  storeuserinf()
    {
        String weekday,hour1,hour2,hour3,hour4,name,phone,mobile,address,Monday,Tuesday,Wednesday;
        String Thursday,Friday,Saturday,Sunday;

        Monday="Monday";
        Tuesday="Tuesday";
        Wednesday="Wednesday";
        Thursday="Thursday";
        Friday="Friday";
        Saturday="Saturday";
        Sunday="Sunday";
        weekday=day;
        hour1=txt1.getText().toString().trim();
        hour2=txt2.getText().toString().trim();
        hour3=txt3.getText().toString().trim();
        hour4=txt4.getText().toString().trim();
        name=txt5.getText().toString().trim();
        phone=txt6.getText().toString().trim();
        mobile=txt7.getText().toString().trim();
        address=txt8.getText().toString().trim();


        saveinformation saveinformation=new saveinformation(name,phone,mobile,address);
        savedaysandhours savedaysandhours=new savedaysandhours(weekday,hour1,hour2,hour3,hour4);
        reference.child(name).child("working days and hours").child(weekday).setValue(savedaysandhours);
        reference.child(name).child("info").setValue(saveinformation);
        if(weekday.equals(Monday))
        {
            txt9.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Tuesday))
        {
            txt10.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Wednesday))
        {
            txt11.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Thursday))
        {
            txt12.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Friday))
        {
            txt13.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Saturday))
        {
            txt14.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }else if(weekday.equals(Sunday))
        {
            txt15.setText(weekday + "from: " + hour1 + " to:" + hour2 + "Evening from: " + hour3 + " to: " + hour4);
        }
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    day=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void readFromDatabase(){

    }
}


