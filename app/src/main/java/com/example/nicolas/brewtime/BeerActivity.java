package com.example.nicolas.brewtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
//        RelativeLayout relativeLayout = (RelativeLayout)this.findViewById(R.id.);
//        RelativeLayout relativeLayout2 = (RelativeLayout)this.findViewById(2131624079);
//        RelativeLayout relativeLayout3 = (RelativeLayout)this.findViewById(2131624078);
//        RelativeLayout relativeLayout4 = (RelativeLayout)this.findViewById(2131624080);
//        RelativeLayout relativeLayout5 = (RelativeLayout)this.findViewById(2131624081);
    }


}
