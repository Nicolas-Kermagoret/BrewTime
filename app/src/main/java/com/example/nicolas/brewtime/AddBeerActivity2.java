package com.example.nicolas.brewtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by nicolas on 25/08/16.
 */
public class AddBeerActivity2 extends AppCompatActivity {

    Spinner primaire;
    Spinner secondaire;
    Spinner garde;
    Spinner refermentation;
    private Calendar myDate;
    private SimpleDateFormat sdf;
    Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity_2);

        this.myDate = Calendar.getInstance();
        this.sdf = new SimpleDateFormat("dd/MM/yy", Locale.FRENCH);
        this.beer = (Beer)this.getIntent().getSerializableExtra("Beer");
        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.setSpinners();

    }

    public void setSpinners(){

        this.primaire = (Spinner)findViewById(R.id.spinner_primaire);
        ArrayAdapter<CharSequence> adpater_primaire = ArrayAdapter.createFromResource(this, R.array.fermentation_primaire, android.R.layout.simple_spinner_item);
        adpater_primaire.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.primaire.setAdapter(adpater_primaire);
        this.primaire.setSelection(2);

        this.secondaire = (Spinner)findViewById(R.id.spinner_secondaire);
        ArrayAdapter<CharSequence> adpater_secondaire = ArrayAdapter.createFromResource(this, R.array.fermentation_secondaire, android.R.layout.simple_spinner_item);
        adpater_secondaire.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.secondaire.setAdapter(adpater_secondaire);
        this.secondaire.setSelection(2);

        this.garde = (Spinner)findViewById(R.id.spinner_garde);
        ArrayAdapter<CharSequence> adpater_garde = ArrayAdapter.createFromResource(this, R.array.garde, android.R.layout.simple_spinner_item);
        adpater_garde.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.garde.setAdapter(adpater_garde);
        this.garde.setSelection(2);

        this.refermentation = (Spinner)findViewById(R.id.spinner_refermentation);
        ArrayAdapter<CharSequence> adpater_refermentation = ArrayAdapter.createFromResource(this, R.array.refermentation, android.R.layout.simple_spinner_item);
        adpater_refermentation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.refermentation.setAdapter(adpater_refermentation);
        this.refermentation.setSelection(1);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.bar_done) {

            this.setFermentationPrimaire();
            this.setFermentationSecondaire();
            this.setGarde();
            this.setRefermentation();

            Intent intent = new Intent(this.getApplicationContext(), (Class)AddBeerActivity3.class);
            intent.putExtra("Beer", (Serializable)this.beer);
            this.startActivity(intent);
        }
        return true;
    }

    public void setFermentationPrimaire() {
        int n = 5 + this.primaire.getSelectedItemPosition();
        this.myDate = this.beer.getCalendarBrassage();
        this.myDate.add(Calendar.DAY_OF_MONTH, n);
        this.beer.setSecondaire(this.sdf.format(this.myDate.getTime()));
    }

    public void setFermentationSecondaire() {
        int n = 7 * (1 + this.secondaire.getSelectedItemPosition());
        this.myDate.add(Calendar.DAY_OF_MONTH, n);
        this.beer.setGarde(this.sdf.format(this.myDate.getTime()));
    }

    public void setGarde() {
        int n = 5 + this.garde.getSelectedItemPosition();
        this.myDate.add(Calendar.DAY_OF_MONTH, n);
        this.beer.setEmbouteillage(this.sdf.format(this.myDate.getTime()));
    }

    public void setRefermentation() {
        int n = 7 * (1 + this.refermentation.getSelectedItemPosition());
        this.myDate.add(Calendar.DAY_OF_MONTH, n);
        this.beer.setDegustation(this.sdf.format(this.myDate.getTime()));
    }

}

