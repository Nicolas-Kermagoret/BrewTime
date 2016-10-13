package com.example.nicolas.brewtime;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by nicolas on 24/08/16.
 */
public class AddBeerActivity extends AppCompatActivity {

    ImageButton addDate;
    TextView brassageDate;
    Beer beer;
    DatePickerDialog.OnDateSetListener date;
    Calendar myCalendar = Calendar.getInstance();

    public AddBeerActivity() {
        this.date = new DatePickerDialog.OnDateSetListener(){

            public void onDateSet(DatePicker datePicker, int n, int n2, int n3) {
                AddBeerActivity.this.myCalendar.set(Calendar.YEAR, n);
                AddBeerActivity.this.myCalendar.set(Calendar.MONTH, n2);
                AddBeerActivity.this.myCalendar.set(Calendar.DAY_OF_MONTH, n3);
                AddBeerActivity.this.updateLabel();
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity);

        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle("Ajouter bière");
        this.brassageDate = (TextView)findViewById(R.id.ask_date);

        this.beer = new Beer();
        this.addDate = (ImageButton)this.findViewById(R.id.calendar);

        this.addDate.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                new DatePickerDialog((Context)AddBeerActivity.this, AddBeerActivity.this.date, AddBeerActivity.this.myCalendar.get(Calendar.YEAR), AddBeerActivity.this.myCalendar.get(Calendar.MONTH), AddBeerActivity.this.myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.FRENCH);
        this.brassageDate.setText((CharSequence)simpleDateFormat.format(this.myCalendar.getTime()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.bar_done) {
            EditText name = (EditText)this.findViewById(R.id.ask_name);
            EditText type = (EditText)this.findViewById(R.id.ask_type);
            EditText quantity = (EditText)this.findViewById(R.id.ask_quantity);
            TextView date = (TextView)this.findViewById(R.id.ask_date);
            this.beer.setName(name.getText().toString());
            this.beer.setType(type.getText().toString());
            this.beer.setQuantity(quantity.getText().toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.FRENCH);
            this.beer.setBrassage((String)simpleDateFormat.format(this.myCalendar.getTime()));
            this.beer.setCalendarBrassage(this.myCalendar);
            Intent intent = new Intent(this.getApplicationContext(), (Class)AddBeerActivity2.class);
            intent.putExtra("Beer", (Serializable)this.beer);
            this.startActivity(intent);
        }
        return true;
    }
}
