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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolas on 26/08/16.
 */
public class AddBeerActivity3 extends AppCompatActivity{

    Beer beer;
    ArrayList<Ingredient> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity_3);
        final Context context = this.getApplicationContext();
        final LinearLayout layoutPopUp = new LinearLayout(this);

        this.ingredients = new ArrayList<Ingredient>();

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

                final View dialogView = inflater.inflate(R.layout.add_ingredient, null);
                TextView textAddIngredient =(TextView)dialogView.findViewById(R.id.title_add_ingredient);
                textAddIngredient.setText("Ajouter Malt");
                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText name = (EditText)dialogView.findViewById(R.id.ingredient_name);
                                EditText quantity = (EditText)dialogView.findViewById(R.id.ingredient_quantity);
                                Ingredient ingredient = new Ingredient(name.getText().toString(), "Malt", Integer.parseInt(quantity.getText().toString()));
                                ingredients.add(ingredient);
                                inflateIngredient(ingredient);
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

                final View dialogView = inflater.inflate(R.layout.add_ingredient, null);
                TextView textAddIngredient =(TextView)dialogView.findViewById(R.id.title_add_ingredient);
                textAddIngredient.setText("Ajouter Houblon Amerisant");
                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText name = (EditText)dialogView.findViewById(R.id.ingredient_name);
                                EditText quantity = (EditText)dialogView.findViewById(R.id.ingredient_quantity);
                                Ingredient ingredient = new Ingredient(name.getText().toString(), "Houblon Amerisant", Integer.parseInt(quantity.getText().toString()));
                                ingredients.add(ingredient);
                                inflateIngredient(ingredient);
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

                final View dialogView = inflater.inflate(R.layout.add_ingredient, null);
                TextView textAddIngredient =(TextView)dialogView.findViewById(R.id.title_add_ingredient);
                textAddIngredient.setText("Ajouter Houblon Aromatisant");
                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText name = (EditText)dialogView.findViewById(R.id.ingredient_name);
                                EditText quantity = (EditText)dialogView.findViewById(R.id.ingredient_quantity);
                                Ingredient ingredient = new Ingredient(name.getText().toString(), "Houblon Aromatisant", Integer.parseInt(quantity.getText().toString()));
                                ingredients.add(ingredient);
                                inflateIngredient(ingredient);
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

                final View dialogView = inflater.inflate(R.layout.add_ingredient, null);
                TextView textAddIngredient =(TextView)dialogView.findViewById(R.id.title_add_ingredient);
                textAddIngredient.setText("Ajouter Epice");
                //textPopUp.setText("Malt");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText name = (EditText)dialogView.findViewById(R.id.ingredient_name);
                                EditText quantity = (EditText)dialogView.findViewById(R.id.ingredient_quantity);
                                Ingredient ingredient = new Ingredient(name.getText().toString(), "Epice", Integer.parseInt(quantity.getText().toString()));
                                ingredients.add(ingredient);
                                inflateIngredient(ingredient);
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
                final View dialogView = inflater.inflate(R.layout.add_ingredient, null);
                TextView textAddIngredient =(TextView)dialogView.findViewById(R.id.title_add_ingredient);
                textAddIngredient.setText("Ajouter Levure");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(dialogView)
                        // Add action buttons
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                                EditText name = (EditText)dialogView.findViewById(R.id.ingredient_name);
                                EditText quantity = (EditText)dialogView.findViewById(R.id.ingredient_quantity);
                                Ingredient ingredient = new Ingredient(name.getText().toString(), "Levure", Integer.parseInt(quantity.getText().toString()));
                                ingredients.add(ingredient);
                                inflateIngredient(ingredient);

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

    public void inflateIngredient(Ingredient ingredientToAdd){
        LinearLayout layout = (LinearLayout)findViewById(R.id.list_ingredients);

        View ingredient = getLayoutInflater().inflate(R.layout.list_ingredient, null);

        TextView name = (TextView)ingredient.findViewById(R.id.list_ingredient_name);
        name.setText(ingredientToAdd.getName());
        TextView type = (TextView)ingredient.findViewById(R.id.list_ingredient_type);
        type.setText(ingredientToAdd.getType());
        TextView quantity = (TextView)ingredient.findViewById(R.id.list_ingredient_quantity);
        quantity.setText(String.valueOf(ingredientToAdd.getQuantity())+" g");

        layout.addView(ingredient);

    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.bar_done) {

            this.setIngredients();

            Intent intent = new Intent(this.getApplicationContext(), (Class)ValidateBeer.class);
            intent.putExtra("Beer", (Serializable)this.beer);
            this.startActivity(intent);
        }
        return true;
    }

    public void setIngredients(){
        this.beer.setIngredients(ingredients);
    }

}
