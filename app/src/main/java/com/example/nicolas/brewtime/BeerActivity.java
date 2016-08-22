package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
        TextView[] arrtextView = new TextView[beer.getMalts().size()];
        TextView[] arrtextView2 = new TextView[beer.getHoublonsArome().size()];
        TextView[] arrtextView3 = new TextView[beer.getHoublonsAmer().size()];
        TextView[] arrtextView4 = new TextView[beer.getEpices().size()];
        TextView[] arrtextView5 = new TextView[beer.getLevures().size()];
        RelativeLayout malts = (RelativeLayout)this.findViewById(R.id.malt);
        RelativeLayout amer= (RelativeLayout)this.findViewById(R.id.amer);
        RelativeLayout arome= (RelativeLayout)this.findViewById(R.id.arome);
        RelativeLayout epices= (RelativeLayout)this.findViewById(R.id.epice);
        RelativeLayout levure= (RelativeLayout)this.findViewById(R.id.levure);

        int n = 1;
        for (int i = 0; i < beer.getMalts().size(); ++i) {
            TextView textView8;
            arrtextView[i] = textView8 = new TextView((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getMalts().size() > 1) {
                arrtextView[i].setId(n);
                ++n;
            }
            if (i > 0) {
                layoutParams.addRule(3, arrtextView[i - 1].getId());
            }
            layoutParams.addRule(11);
            arrtextView[i].setTextSize(2, 16.0f);
            arrtextView[i].setText((CharSequence)((String)beer.getMalts().get(i) + " " + (String)beer.getMaltsQuantity().get(i)));
            malts.addView((View)arrtextView[i], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int j = 0; j < beer.getHoublonsArome().size(); ++j) {
            TextView textView9;
            arrtextView2[j] = textView9 = new TextView((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getHoublonsArome().size() > 1) {
                arrtextView2[j].setId(n);
                ++n;
            }
            if (j > 0) {
                layoutParams.addRule(3, arrtextView2[j - 1].getId());
            }
            layoutParams.addRule(11);
            arrtextView2[j].setTextSize(2, 16.0f);
            arrtextView2[j].setText((CharSequence)((String)beer.getHoublonsArome().get(j) + " " + (String)beer.getHoublonsAromeQuantity().get(j)));
            arome.addView((View)arrtextView2[j], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int k = 0; k < beer.getHoublonsAmer().size(); ++k) {
            TextView textView10;
            arrtextView3[k] = textView10 = new TextView((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getHoublonsAmer().size() > 1) {
                arrtextView3[k].setId(n);
                ++n;
            }
            if (k > 0) {
                layoutParams.addRule(3, arrtextView3[k - 1].getId());
            }
            layoutParams.addRule(11);
            arrtextView3[k].setTextSize(2, 16.0f);
            arrtextView3[k].setText((CharSequence)((String)beer.getHoublonsAmer().get(k) + " " + (String)beer.getHoublonsAmerQuantity().get(k)));
            amer.addView((View)arrtextView3[k], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int i2 = 0; i2 < beer.getEpices().size(); ++i2) {
            TextView textView11;
            arrtextView4[i2] = textView11 = new TextView((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getEpices().size() > 1) {
                arrtextView4[i2].setId(n);
                ++n;
            }
            if (i2 > 0) {
                layoutParams.addRule(3, arrtextView4[i2 - 1].getId());
            }
            layoutParams.addRule(11);
            arrtextView4[i2].setTextSize(2, 16.0f);
            arrtextView4[i2].setText((CharSequence)((String)beer.getEpices().get(i2) + " " + (String)beer.getEpicesQuantity().get(i2)));
            epices.addView((View)arrtextView4[i2], (ViewGroup.LayoutParams)layoutParams);
        }
        for (int i3 = 0; i3 < beer.getLevures().size(); ++i3) {
            TextView textView12;
            arrtextView5[i3] = textView12 = new TextView((Context)this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (beer.getLevures().size() > 1) {
                arrtextView[i3].setId(n);
                ++n;
            }
            if (i3 > 0) {
                layoutParams.addRule(3, arrtextView5[i3 - 1].getId());
            }
            layoutParams.addRule(11);
            arrtextView5[i3].setTextSize(2, 16.0f);
            arrtextView5[i3].setText((CharSequence)((String)beer.getLevures().get(i3) + " " + (String)beer.getLevuresQuantity().get(i3)));
            levure.addView((View)arrtextView5[i3], (ViewGroup.LayoutParams)layoutParams);
        }
    }


}
