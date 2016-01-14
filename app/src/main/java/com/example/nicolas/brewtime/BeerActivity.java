package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by nicolas on 14/01/16.
 */
public class BeerActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_display);

        Intent i = getIntent();
    }


}
