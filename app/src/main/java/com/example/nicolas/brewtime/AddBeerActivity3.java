package com.example.nicolas.brewtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

/**
 * Created by nicolas on 26/08/16.
 */
public class AddBeerActivity3 extends AppCompatActivity {

    Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity_3);

        this.beer = (Beer)this.getIntent().getSerializableExtra("Beer");

        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle("Ingredients");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }


}
