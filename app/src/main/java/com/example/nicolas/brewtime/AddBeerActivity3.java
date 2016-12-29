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
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nicolas on 26/08/16.
 */
public class AddBeerActivity3 extends AppCompatActivity{

    private Beer beer;
    private ArrayList<Ingredient> ingredients;
    @BindView(R.id.listViewIngredients) ListView mListView;
    private List<Map<String, String>> listeIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_beer_activity_3);
        final Context context = this.getApplicationContext();
        final LinearLayout layoutPopUp = new LinearLayout(this);

        ButterKnife.bind(this);

        this.ingredients = new ArrayList<Ingredient>();
        this.listeIngredients = new ArrayList<>();

        DialogFragment fragment;

        final AppCompatActivity activity = this;

        final FloatingActionsMenu add_ingredient_menu = (FloatingActionsMenu) this.findViewById(R.id.add_ingredient);

        final FloatingActionButton add_malt = (FloatingActionButton) this.findViewById(R.id.add_malt);

        this.beer = (Beer) this.getIntent().getSerializableExtra("Beer");
        this.setSupportActionBar((Toolbar) this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

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
                                if (!name.getText().toString().matches("") && !quantity.getText().toString().matches("")) {
                                    Ingredient ingredient = new Ingredient(name.getText().toString(), "malt", Integer.parseInt(quantity.getText().toString()));
                                    addIngredient(ingredient);
//                                    ingredients.add(ingredient);
//                                    inflateIngredient(ingredient);
                                    Log.d("TEST", "Add ingredient");
                                }
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
                                if (!name.getText().toString().matches("") && !quantity.getText().toString().matches("")) {
                                    Ingredient ingredient = new Ingredient(name.getText().toString(), "houblonAm", Integer.parseInt(quantity.getText().toString()));
                                    addIngredient(ingredient);
//                                    ingredients.add(ingredient);
//                                    inflateIngredient(ingredient);
                                    Log.d("TEST", "Add ingredient");
                                }
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
                                if (!name.getText().toString().matches("") && !quantity.getText().toString().matches("")) {
                                    Ingredient ingredient = new Ingredient(name.getText().toString(), "houblonAr", Integer.parseInt(quantity.getText().toString()));
                                    addIngredient(ingredient);
//                                    ingredients.add(ingredient);
//                                    inflateIngredient(ingredient);
                                    Log.d("TEST", "Add ingredient");
                                }
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
                                if (!name.getText().toString().matches("") && !quantity.getText().toString().matches("")) {
                                    Ingredient ingredient = new Ingredient(name.getText().toString(), "epice", Integer.parseInt(quantity.getText().toString()));
                                    addIngredient(ingredient);
//                                    ingredients.add(ingredient);
//                                    inflateIngredient(ingredient);
                                    Log.d("TEST", "Add ingredient");
                                }
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
                                if (!name.getText().toString().matches("") && !quantity.getText().toString().matches("")) {
                                    Ingredient ingredient = new Ingredient(name.getText().toString(), "levure", Integer.parseInt(quantity.getText().toString()));
                                    addIngredient(ingredient);
//                                    ingredients.add(ingredient);
//                                    inflateIngredient(ingredient);
                                }

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Log.d("CASE", "Edit");
                editIngredient(info.id);
                return true;
            case R.id.delete:
                deleteIngredient(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void editIngredient(long id){
        Log.d("Edit beer","lalalala");
    }

    public void deleteIngredient(long id){

    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        HashMap<String, String> element;
        element = new HashMap<>();
        element.put("name",ingredient.getName());
        element.put("type", ingredient.getType());
        element.put("quantity", Integer.toString(ingredient.getQuantity()) +"g");
        this.listeIngredients.add(element);
        this.displayIngredients();

    }

    public void displayIngredients(){

//        if(deleting){
//            mListView.setAdapter(null);
//        }


        String[] from = {"name", "type", "quantity"};
        int[] to = {R.id.list_ingredient_name, R.id.list_ingredient_type, R.id.list_ingredient_quantity};

        //Instanciation du SimpleAdapter avec ce qu'on veut afficher dans le ListView

        ListAdapter adapter = new SimpleAdapter(this, this.listeIngredients, R.layout.list_ingredient, from, to);

        mListView.setAdapter(adapter);

    }

}
