package com.example.nicolas.brewtime;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.api.client.util.DateTime;


import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Calendar;

import static android.provider.CalendarContract.Events.*;

/**
 * Created by nicolas on 11/10/16.
 */

public class ValidateBeer extends AppCompatActivity {

    Beer beer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_display);

        this.beer = (Beer) this.getIntent().getSerializableExtra("Beer");
        this.setSupportActionBar((Toolbar) this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView type = (TextView) this.findViewById(R.id.beer_type);
        TextView date = (TextView) this.findViewById(R.id.beer_date);
        TextView quantity = (TextView) this.findViewById(R.id.beer_quantity);
        TextView secondaire = (TextView) this.findViewById(R.id.ferm_sec_date);
        TextView garde = (TextView) this.findViewById(R.id.garde_date);
        TextView embouteillage = (TextView) this.findViewById(R.id.embouteillage_date);
        TextView degustation = (TextView) this.findViewById(R.id.degustation_date);
        ImageView imageView = (ImageView) this.findViewById(R.id.beer_icon);


        type.setText(beer.getType());
        date.setText(beer.getBrassage());
        quantity.setText(beer.getQuantity()+"L");
        secondaire.setText(beer.getSecondaire());
        garde.setText(beer.getGarde());
        embouteillage.setText(beer.getEmbouteillage());
        degustation.setText(beer.getDegustation());

        int picturePath = this.getResources().getIdentifier("beer_icon_" + beer.getType().toLowerCase(), "drawable", this.getPackageName());
        if (picturePath == 0){
            picturePath = this.getResources().getIdentifier("beer_icon_blonde", "drawable", this.getPackageName());
        }

        imageView.setImageResource(picturePath);
        TextView[] maltText = new TextView[beer.getMalts().size()];
        TextView[] aromeText = new TextView[beer.getHoublonsArome().size()];
        TextView[] amerText = new TextView[beer.getHoublonsAmer().size()];
        TextView[] epiceText = new TextView[beer.getEpices().size()];
        TextView[] levureText = new TextView[beer.getLevures().size()];
        RelativeLayout malts = (RelativeLayout) this.findViewById(R.id.malt);
        RelativeLayout amer = (RelativeLayout) this.findViewById(R.id.amer);
        RelativeLayout arome = (RelativeLayout) this.findViewById(R.id.arome);
        RelativeLayout epices = (RelativeLayout) this.findViewById(R.id.epice);
        RelativeLayout levure = (RelativeLayout) this.findViewById(R.id.levure);

        int n = 1;
        for (int i = 0; i < beer.getMalts().size(); ++i) {
            maltText[i] = new TextView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getMalts().size() > 1) {
                maltText[i].setId(n);
                ++n;
            }
            if (i > 0) {
                layoutParams.addRule(3, maltText[i - 1].getId());
            }
            layoutParams.addRule(11);
            maltText[i].setTextSize(2, 16.0f);
            maltText[i].setText(beer.getMalts().get(i).getName() + " " + beer.getMalts().get(i).getQuantity() + "g");
            malts.addView(maltText[i], layoutParams);
        }
        for (int j = 0; j < beer.getHoublonsArome().size(); ++j) {
            aromeText[j] = new TextView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getHoublonsArome().size() > 1) {
                aromeText[j].setId(n);
                ++n;
            }
            if (j > 0) {
                layoutParams.addRule(3, aromeText[j - 1].getId());
            }
            layoutParams.addRule(11);
            aromeText[j].setTextSize(2, 16.0f);
            aromeText[j].setText(beer.getHoublonsArome().get(j).getName() + " " + beer.getHoublonsArome().get(j).getQuantity() + "g");
            arome.addView(aromeText[j], layoutParams);
        }
        for (int i = 0; i < beer.getHoublonsAmer().size(); ++i) {
            amerText[i] = new TextView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getHoublonsAmer().size() > 1) {
                amerText[i].setId(n);
                ++n;
            }
            if (i > 0) {
                layoutParams.addRule(3, amerText[i - 1].getId());
            }
            layoutParams.addRule(11);
            amerText[i].setTextSize(2, 16.0f);
            amerText[i].setText(beer.getHoublonsAmer().get(i).getName() + " " + beer.getHoublonsAmer().get(i).getQuantity() + "g");
            amer.addView(amerText[i], layoutParams);
        }
        for (int i = 0; i < beer.getEpices().size(); ++i) {
            epiceText[i] = new TextView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getEpices().size() > 1) {
                epiceText[i].setId(n);
                ++n;
            }
            if (i > 0) {
                layoutParams.addRule(3, epiceText[i - 1].getId());
            }
            layoutParams.addRule(11);
            epiceText[i].setTextSize(2, 16.0f);
            epiceText[i].setText(beer.getEpices().get(i).getName() + " " + beer.getEpices().get(i).getQuantity() + "g");
            epices.addView(epiceText[i], layoutParams);
        }
        for (int i = 0; i < beer.getLevures().size(); ++i) {
            levureText[i] = new TextView(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getLevures().size() > 1) {
                epiceText[i].setId(n);
                ++n;
            }
            if (i > 0) {
                layoutParams.addRule(3, levureText[i - 1].getId());
            }
            layoutParams.addRule(11);
            levureText[i].setTextSize(2, 16.0f);
            levureText[i].setText(beer.getLevures().get(i).getName() + " " + beer.getLevures().get(i).getQuantity() + "g");
            levure.addView(levureText[i], layoutParams);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.bar_done) {


            addToCalendar();
            this.toJson();

            Intent intent = new Intent(this.getApplicationContext(), (Class)MainActivity.class);
            this.startActivity(intent);
        }
        return true;
    }

    public void addToCalendar() {

        long[] calendarIds = new long[5];

        calendarIds[0] = addDateToCalendar(this.beer.getBrassage(), "Brassage");
        calendarIds[1] = addDateToCalendar(this.beer.getSecondaire(), "Fermentation Secondaire");
        calendarIds[2] = addDateToCalendar(this.beer.getGarde(), "Mise en Garde");
        calendarIds[3] = addDateToCalendar(this.beer.getEmbouteillage(), "Embouteillage");
        calendarIds[4] = addDateToCalendar(this.beer.getDegustation(), "Degustation");

        this.beer.setCalendarIds(calendarIds);
    }

    public String[] splitDate(String date){
        String[] split = date.split("/");
        return split;
    }

    public long addDateToCalendar(String dateToAdd, String operation){

        String[] date = splitDate(dateToAdd);

        long calID = 1;
        long startMillis = 0;
        long endMillis = 0;
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(Integer.parseInt("20"+date[2]), Integer.parseInt(date[1])-1, Integer.parseInt(date[0]), 9, 00);
        startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(Integer.parseInt("20"+date[2]), Integer.parseInt(date[1])-1, Integer.parseInt(date[0]), 22, 00);
        endMillis = endTime.getTimeInMillis();


        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(DTSTART, startMillis);
        values.put(DTEND, endMillis);
        values.put(TITLE, this.beer.getName() + " "+ operation);
//        values.put(DESCRIPTION, "Group workout");
        values.put(CALENDAR_ID, calID);
        values.put(EVENT_TIMEZONE, "Europe/Paris");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            Log.d("TEST", "No permission");
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }

        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
        Log.d("adding beer", "done");

// get the event ID that is the last element in the Uri
//        long eventID = Long.parseLong(uri.getLastPathSegment());
        return  Long.parseLong(uri.getLastPathSegment());

    }

    public void toJson(){
        Gson gson = new Gson();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.getApplicationContext().openFileOutput(beer.getName()+".json", Context.MODE_PRIVATE));

            String data_beer = gson.toJson(this.beer);
            outputStreamWriter.write(data_beer);
            outputStreamWriter.close();


        } catch (FileNotFoundException e) {
            Log.e("Exception","Open file failed" + e.toString());
        } catch (IOException e) {
            Log.e("Exception","File write failed" + e.toString());
        }
    }









}