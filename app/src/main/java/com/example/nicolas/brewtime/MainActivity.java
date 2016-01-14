package com.example.nicolas.brewtime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Beer> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciation du Parser XML qui va recuperer toutes les bières et les mettre dans beers

        XMLParser parser = new XMLParser();
        XmlPullParser pullParser= getResources().getXml(R.xml.beers);
        parser.parse(pullParser);
        this.beers = parser.getBeers();

        mListView = (ListView) findViewById(R.id.listView);

        List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
        HashMap<String, String> element;

        //Mettre le nom, la date de brassage et l'icone de chaque biere dans une liste pour l'afficher

        for(int i=0; i<this.beers.size(); i++){
            element = new HashMap<String, String>();
            element.put("name",this.beers.get(i).getName());
            element.put("date", this.beers.get(i).getBrassage());

            //Recuperer le nom de l'icone à partir du type de bière et recuperer son id puis repasser ça en String

            element.put("image",Integer.toString(getResources().getIdentifier("beer_icon_" + this.beers.get(i).getType().toLowerCase(), "drawable", getPackageName())));
            liste.add(element);
        }

        String[] from = {"name", "date", "image"};
        int[] to = {R.id.beer_name_list, R.id.beer_date_list, R.id.beer_icon_list};

        //Instanciation du SimpleAdapter avec ce qu'on veut afficher dans le ListView

        ListAdapter adapter = new SimpleAdapter(this, liste, R.layout.list_item, from, to);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), BeerActivity.class);
                // sending data to new activity
                i.putExtra("beer", "product");
                startActivity(i);

            }
        });


        //ListesActivity listActivity = new ListesActivity();

    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
        private ImageView personImageView;
    }

}


