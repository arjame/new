package com.example.lab2firebase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class RestaurantProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_profile);

        //***********open new activity to add daily offers
        ImageButton btnDailyOffer = findViewById(R.id.btnDailyOffer);
        btnDailyOffer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openDailyOffer();
            }
        });
        //End of btn Daily offers


        //***********Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //end Toolbar

    }
    //**************Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle toolbar item clicks here.
        int id = item.getItemId();
        //If Edit_button has been pressed go to the Edit activity
        if (id == R.id.btn_edit) {
            Intent i = new Intent(this, EditRestaurantProfile.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    //End toolbar

    //***********open Daily offers page
    public void openDailyOffer(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //.....End daily offer
}
