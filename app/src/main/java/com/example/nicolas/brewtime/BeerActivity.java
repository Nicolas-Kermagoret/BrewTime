package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolas on 14/01/16.
 */
public class BeerActivity extends AppCompatActivity{

    Beer beer;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_display);

        Gson gson = new Gson();

        this.beer = (Beer)this.getIntent().getSerializableExtra("Beer");

        String beerJson = gson.toJson(this.beer);
//
//        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
//        getSupportActionBar().setTitle(beer.getName());
//        setSupportActionBar(mActionBarToolbar);

        this.setSupportActionBar((Toolbar)this.findViewById(R.id.toolbar));
        this.getSupportActionBar().setTitle(beer.getName());


        TextView type = (TextView)this.findViewById(R.id.beer_type);
        TextView date = (TextView)this.findViewById(R.id.beer_date);
        TextView quantity = (TextView)this.findViewById(R.id.beer_quantity);
        TextView secondaire = (TextView)this.findViewById(R.id.ferm_sec_date);
        TextView garde = (TextView)this.findViewById(R.id.garde_date);
        TextView embouteillage = (TextView)this.findViewById(R.id.embouteillage_date);
        TextView degustation = (TextView)this.findViewById(R.id.degustation_date);
        ImageView imageView = (ImageView)this.findViewById(R.id.beer_icon);


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
        Log.d("Taille Houblon Arome", Integer.toString(beer.getHoublonsArome().size()));

        TextView[] amerText = new TextView[beer.getHoublonsAmer().size()];
        TextView[] epiceText = new TextView[beer.getEpices().size()];
        TextView[] levureText = new TextView[beer.getLevures().size()];

        RelativeLayout malts = (RelativeLayout)this.findViewById(R.id.malt);
        RelativeLayout amer= (RelativeLayout)this.findViewById(R.id.amer);
        RelativeLayout arome= (RelativeLayout)this.findViewById(R.id.arome);
        RelativeLayout epices= (RelativeLayout)this.findViewById(R.id.epice);
        RelativeLayout levure= (RelativeLayout)this.findViewById(R.id.levure);

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
            maltText[i].setText(beer.getMalts().get(i).getName() + " " + beer.getMalts().get(i).getQuantity()+"g");
            malts.addView(maltText[i], layoutParams);
        }
        for (int j = 0; j < beer.getHoublonsArome().size(); ++j) {
            aromeText[j] =new TextView(this);
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
            aromeText[j].setText(beer.getHoublonsArome().get(j).getName() + " " + beer.getHoublonsArome().get(j).getQuantity()+"g");
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
            amerText[i].setText(beer.getHoublonsAmer().get(i).getName() + " " + beer.getHoublonsAmer().get(i).getQuantity()+"g");
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
            epiceText[i].setText(beer.getEpices().get(i).getName() + " " + beer.getEpices().get(i).getQuantity()+"g");
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
            levureText[i].setText(beer.getLevures().get(i).getName() + " " + beer.getLevures().get(i).getQuantity()+"g");
            levure.addView(levureText[i], layoutParams);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.send_by_email, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.email_done) {

            String beerName = "Nom , " +beer.getName() +"\n";
            String beerType = "Type , " + beer.getType()+"\n";
            String beerQuantity = "Quantity , " + beer.getQuantity()+"L\n";
            String beerBrassageDate = "Brassage , " + beer.getBrassage()+"\n";
            String beerSecondaireDate = "Fermentation secondaire , " + beer.getSecondaire()+"\n";
            String beerGardeDate = "Garde , " + beer.getGarde()+"\n";
            String beerEmbouteillageDate = "Embouteillage , " + beer.getEmbouteillage()+"\n";
            String beerDegustationDate = "Degustation , " + beer.getDegustation()+"\n";
            String beerIngredients = "Ingredient, Nom, Quantity"+"\n";

            String malts ="";
            String houblonsAm ="";
            String houblonsAr ="";
            String epices ="";
            String levures ="";

            for(int i=0; i<this.beer.getMalts().size(); i++){
                malts += "Malt , " + this.beer.getMalts().get(i).getName() + " , " + this.beer.getMalts().get(i).getQuantity() + "g\n";
            }

            for(int i=0; i<this.beer.getHoublonsAmer().size(); i++){
                houblonsAm += "Houblon Amerisant , " + this.beer.getHoublonsAmer().get(i).getName() + " , " + this.beer.getHoublonsAmer().get(i).getQuantity() + "g\n";
            }

            for(int i=0; i<this.beer.getHoublonsArome().size(); i++){
                houblonsAr += "Houblon Aromatisant , " + this.beer.getHoublonsArome().get(i).getName() + " , " + this.beer.getHoublonsArome().get(i).getQuantity() + "g\n";
            }

            for(int i=0; i<this.beer.getEpices().size(); i++){
                epices += "Epice , " + this.beer.getEpices().get(i).getName() + " , " + this.beer.getEpices().get(i).getQuantity() + "g\n";
            }

            for(int i=0; i<this.beer.getLevures().size(); i++){
                levures += "Levure , " + this.beer.getLevures().get(i).getName() + " , " + this.beer.getLevures().get(i).getQuantity() + "g\n";
            }



            String beerToWrite = beerName + beerType + beerQuantity + beerBrassageDate + beerSecondaireDate + beerGardeDate + beerEmbouteillageDate + beerDegustationDate + beerIngredients + malts + houblonsAm + houblonsAr + epices + levures;

            File file   = null;
            File root   = Environment.getExternalStorageDirectory();
            if (root.canWrite()){
                File dir    =   new File (root.getAbsolutePath() + "/PersonData");
                dir.mkdirs();
                String date = formatDate(this.beer.getBrassage());
                file   =   new File(dir, this.beer.getName() +"_"+ this.beer.getType()+"_" + date +".csv");
                Log.d("filename", this.beer.getName() +"_"+ this.beer.getType()+"_" + this.beer.getBrassage() +".csv");
                FileOutputStream out   =   null;
                try {
                    out = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    out.write(beerToWrite.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Uri u1 = Uri.fromFile(file);

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Brassage biere");
                sendIntent.putExtra(Intent.EXTRA_STREAM, u1);
                sendIntent.setType("text/html");
                startActivity(sendIntent);
            }

        }
        return true;
    }

    public String formatDate(String date){
        String[] split = date.split("/");
        String dateFile = split[0] + "-" + split[1] + "-" + split[2];
        return dateFile;
    }


}
