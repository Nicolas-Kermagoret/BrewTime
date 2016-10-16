package com.example.nicolas.brewtime;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Beer> beers = new ArrayList<Beer>();

    public ArrayList<Beer> getBeers() {
        return beers;
    }
    private XMLWriter xml = new XMLWriter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("iiiiiiiiiiiiiiii","=====l==========================================");
        Log.d("", getFilesDir().getAbsolutePath());
        Log.d("","==================================================");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =   (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        XMLParser parser = new XMLParser();

        //Instanciation du Parser XML qui va recuperer toutes les bières et les mettre dans beers
        File folder = new File(getFilesDir().getAbsolutePath());
        File[] listOfFiles = folder.listFiles();
        XmlPullParserFactory xppf = null;
        XmlPullParser xpp = null;
        try {
            xppf = XmlPullParserFactory.newInstance();
            xpp = xppf.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        InputStream is;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                try {
                    System.out.println("File " + listOfFiles[i].getName());
                    is = new FileInputStream(listOfFiles[i].getAbsolutePath());
                    xpp.setInput(is,"utf-8");
                    parser.parse(xpp);
                    Beer test = parser.getBeer();
                    this.beers.add(test);
                } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        }
        mListView = (ListView) findViewById(R.id.listView);

        List<Map<String, String>> liste = new ArrayList<Map<String, String>>();
        HashMap<String, String> element;

        //Mettre le nom, la date de brassage et l'icone de chaque biere dans une liste pour l'afficher

        for(int i=0; i<this.beers.size(); i++){
            element = new HashMap<String, String>();
            element.put("name",this.beers.get(i).getName());
            element.put("date", this.beers.get(i).getBrassage());

            //Recuperer le nom de l'icone à partir du type de bière et recuperer son id puis repasser ça en String

            int picturePath = this.getResources().getIdentifier("beer_icon_" + this.beers.get(i).getType().toLowerCase(), "drawable", this.getPackageName());
            if (picturePath == 0){
                picturePath = this.getResources().getIdentifier("beer_icon_blonde", "drawable", this.getPackageName());
            }

            element.put("image",Integer.toString(picturePath));
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

                Intent intent = new Intent(MainActivity.this.getApplicationContext(), (Class)BeerActivity.class);
                intent.putExtra("Beer", (Serializable)MainActivity.this.beers.get(position));
                MainActivity.this.startActivity(intent);

            }
        });

        ((FloatingActionButton)this.findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), (Class)AddBeerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
        private ImageView personImageView;
    }


}


