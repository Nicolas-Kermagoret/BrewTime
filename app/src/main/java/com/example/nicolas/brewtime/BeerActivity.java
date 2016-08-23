package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nicolas on 14/01/16.
 */
public class BeerActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_display);

        //Intent i = getIntent();

        Beer beer = (Beer)this.getIntent().getSerializableExtra("Beer");

        TextView type = (TextView)this.findViewById(R.id.beer_type);
        TextView date = (TextView)this.findViewById(R.id.beer_date);
        TextView quantity = (TextView)this.findViewById(R.id.beer_quantity);
        TextView secondaire = (TextView)this.findViewById(R.id.ferm_sec_date);
        TextView garde = (TextView)this.findViewById(R.id.garde_date);
        TextView embouteillage = (TextView)this.findViewById(R.id.embouteillage_date);
        TextView degustation = (TextView)this.findViewById(R.id.degustation_date);
        ImageView imageView = (ImageView)this.findViewById(R.id.beer_icon);


        type.setText((CharSequence) beer.getType());
        date.setText((CharSequence)beer.getBrassage());
        quantity.setText((CharSequence)beer.getQuantity());
        secondaire.setText((CharSequence)beer.getSecondaire());
        garde.setText((CharSequence)beer.getGarde());
        embouteillage.setText((CharSequence)beer.getEmbouteillage());
        degustation.setText((CharSequence)beer.getDegustation());

        imageView.setImageResource(this.getResources().getIdentifier("beer_icon_" + beer.getType().toLowerCase(), "drawable", this.getPackageName()));
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
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
            maltText[i] = new TextView((Context)this);
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
            maltText[i].setText((CharSequence)((String)beer.getMalts().get(i) + " " + (String)beer.getMaltsQuantity().get(i)+"g"));
            malts.addView((View)maltText[i], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int j = 0; j < beer.getHoublonsArome().size(); ++j) {
            TextView textView9;
            aromeText[j] =new TextView((Context)this);
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
            aromeText[j].setText((CharSequence)((String)beer.getHoublonsArome().get(j) + " " + (String)beer.getHoublonsAromeQuantity().get(j)+"g"));
            arome.addView((View)aromeText[j], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int i = 0; i < beer.getHoublonsAmer().size(); ++i) {
            TextView textView10;
            amerText[i] = new TextView((Context)this);
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
            amerText[i].setText((CharSequence)((String)beer.getHoublonsAmer().get(i) + " " + (String)beer.getHoublonsAmerQuantity().get(i)+"g"));
            amer.addView((View)amerText[i], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int i = 0; i < beer.getEpices().size(); ++i) {
            TextView textView11;
            epiceText[i] = new TextView((Context)this);
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
            epiceText[i].setText((CharSequence)((String)beer.getEpices().get(i) + " " + (String)beer.getEpicesQuantity().get(i)+"g"));
            epices.addView((View)epiceText[i], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int i = 0; i < beer.getLevures().size(); ++i) {
            TextView textView12;
            levureText[i] = new TextView((Context)this);
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
            levureText[i].setText((CharSequence)((String)beer.getLevures().get(i) + " " + (String)beer.getLevuresQuantity().get(i)+"g"));
            levure.addView((View)levureText[i], (ViewGroup.LayoutParams)layoutParams);
        }
    }


}
