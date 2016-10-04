package com.example.nicolas.brewtime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by nicolas on 26/08/16.
 */
public class AddBeerActivity3 extends AppCompatActivity {

    Beer beer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity_3);
        final Context context = this.getApplicationContext();

        final FloatingActionsMenu add_ingredient_menu = (FloatingActionsMenu)this.findViewById(R.id.add_ingredient);



        this.beer = (Beer)this.getIntent().getSerializableExtra("Beer");

        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle("Ingredients");

        ((FloatingActionButton)this.findViewById(R.id.add_malt)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Log.d("TEST", "Add malt");
                add_ingredient_menu.collapse();

            }
        });

        ((FloatingActionButton)this.findViewById(R.id.add_amer)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Log.d("TEST", "Add houblon amer");
                add_ingredient_menu.collapse();
            }
        });

        ((FloatingActionButton)this.findViewById(R.id.add_arome)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Log.d("TEST", "Add houblon arome");
                add_ingredient_menu.collapse();
            }
        });

        ((FloatingActionButton)this.findViewById(R.id.add_epice)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Log.d("TEST", "Add epice");
                add_ingredient_menu.collapse();
            }
        });

        ((FloatingActionButton)this.findViewById(R.id.add_levure)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Log.d("TEST", "Add levure");
                add_ingredient_menu.collapse();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }


}
