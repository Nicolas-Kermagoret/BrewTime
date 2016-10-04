package com.example.nicolas.brewtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

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
        final LinearLayout layoutPopUp = new LinearLayout(this);

        DialogFragment fragment;

        final AppCompatActivity activity = this;

        final FloatingActionsMenu add_ingredient_menu = (FloatingActionsMenu) this.findViewById(R.id.add_ingredient);

        final FloatingActionButton add_malt = (FloatingActionButton) this.findViewById(R.id.add_malt);

        this.beer = (Beer) this.getIntent().getSerializableExtra("Beer");



        this.setSupportActionBar((Toolbar) this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle("Ingredients");

        ((FloatingActionButton) this.findViewById(R.id.add_malt)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                add_ingredient_menu.collapse();
                // get prompts.xml view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.add_ingredient, null))
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                Log.d("TEST", "Add ingredient");
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                Log.d("TEST", "Cancel ingredient");
                            }
                        });

                Dialog dialog=builder.create();
                dialog.show();
            }

        });

            /*}
        });*/

        ((FloatingActionButton) this.findViewById(R.id.add_amer)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                add_ingredient_menu.collapse();
                // get prompts.xml view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.add_ingredient, null))
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                Log.d("TEST", "Add ingredient");
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                Log.d("TEST", "Cancel ingredient");
                            }
                        });

                Dialog dialog=builder.create();
                dialog.show();
            }
        });

        ((FloatingActionButton) this.findViewById(R.id.add_arome)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                add_ingredient_menu.collapse();
                // get prompts.xml view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.add_ingredient, null))
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                Log.d("TEST", "Add ingredient");
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                Log.d("TEST", "Cancel ingredient");
                            }
                        });

                Dialog dialog=builder.create();
                dialog.show();
            }
        });

        ((FloatingActionButton) this.findViewById(R.id.add_epice)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                add_ingredient_menu.collapse();
                // get prompts.xml view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.add_ingredient, null))
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                Log.d("TEST", "Add ingredient");
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                Log.d("TEST", "Cancel ingredient");
                            }
                        });

                Dialog dialog=builder.create();
                dialog.show();
            }
        });

        ((FloatingActionButton) this.findViewById(R.id.add_levure)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add_ingredient_menu.collapse();
                // get prompts.xml view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.add_ingredient, null))
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                Log.d("TEST", "Add ingredient");
                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                Log.d("TEST", "Cancel ingredient");
                            }
                        });

                Dialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.validation_bar, menu);
        return true;
    }


}
