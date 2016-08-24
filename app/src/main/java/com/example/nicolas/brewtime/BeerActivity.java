package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicolas on 14/01/16.
 */
public class BeerActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_display);

        Beer beer = (Beer)this.getIntent().getSerializableExtra("Beer");
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
        quantity.setText(beer.getQuantity());
        secondaire.setText(beer.getSecondaire());
        garde.setText(beer.getGarde());
        embouteillage.setText(beer.getEmbouteillage());
        degustation.setText(beer.getDegustation());

        imageView.setImageResource(this.getResources().getIdentifier("beer_icon_" + beer.getType().toLowerCase(), "drawable", this.getPackageName()));
        TextView[] maltText = new TextView[beer.getMalts().size()];
        TextView[] aromeText = new TextView[beer.getHoublonsArome().size()];
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
            maltText[i].setText(beer.getMalts().get(i) + " " + beer.getMaltsQuantity().get(i)+"g");
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
            aromeText[j].setText(beer.getHoublonsArome().get(j) + " " + beer.getHoublonsAromeQuantity().get(j)+"g");
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
            amerText[i].setText(beer.getHoublonsAmer().get(i) + " " + beer.getHoublonsAmerQuantity().get(i)+"g");
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
            epiceText[i].setText(beer.getEpices().get(i) + " " + beer.getEpicesQuantity().get(i)+"g");
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
            levureText[i].setText(beer.getLevures().get(i) + " " + beer.getLevuresQuantity().get(i)+"g");
            levure.addView(levureText[i], layoutParams);
        }
    }


}
