package com.example.nicolas.brewtime;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by nicolas on 24/08/16.
 */
public class AddBeerActivity extends AppCompatActivity {

    ImageButton addDate;
    Beer beer;
    DatePickerDialog.OnDateSetListener date;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity);

        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle("Ajouter bière");

        this.beer = new Beer();
        this.addDate = (ImageButton)this.findViewById(R.id.calendar);
        this.addDate.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                new DatePickerDialog((Context)AddBeerActivity.this, AddBeerActivity.this.date, AddBeerActivity.this.myCalendar.get(Calendar.DAY_OF_MONTH), AddBeerActivity.this.myCalendar.get(Calendar.MONTH), AddBeerActivity.this.myCalendar.get(Calendar.YEAR)).show();
            }
        });
    }
}
