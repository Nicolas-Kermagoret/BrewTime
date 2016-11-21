package com.example.nicolas.brewtime;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Beer> beers = new ArrayList<Beer>();

    public ArrayList<Beer> getBeers() {
        return beers;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        this.fromJson();

        mListView = (ListView) findViewById(R.id.listView);

        List<Map<String, String>> liste = new ArrayList<>();
        HashMap<String, String> element;

        //Mettre le nom, la date de brassage et l'icone de chaque biere dans une liste pour l'afficher

        for(int i=0; i<this.beers.size(); i++){
            element = new HashMap<>();
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

//        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//                                           int pos, long id) {
//                // TODO Auto-generated method stub
//
//                Log.v("long clicked","pos: " + pos);
//
//                return true;
//            }
//        });

        ((FloatingActionButton)this.findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), (Class)AddBeerActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        registerForContextMenu(mListView);

    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView surnameTextView;
        private ImageView personImageView;
    }

    public void fromJson(){
        File folder = new File(getFilesDir().getAbsolutePath());
        File[] listOfFiles = folder.listFiles();

        Gson gson = new Gson();

        for (File file : listOfFiles) {
            String filename = file.getName();
            if(filename.substring(filename.lastIndexOf(".")+1,filename.length()).equals("json")) {
                String beerJson = null;
                try {
                    FileInputStream stream = new FileInputStream(file);

                    FileChannel fc = stream.getChannel();
                    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

                    beerJson = Charset.defaultCharset().decode(bb).toString();

                    stream.close();
                } catch (FileNotFoundException e) {
                    Log.e("Exception", "Open file failed" + e.toString());
                } catch (IOException e) {
                    Log.e("Exception", "Read file failed" + e.toString());
                }

                this.beers.add(gson.fromJson(beerJson, Beer.class));
            }
        }
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
                editBeer(info.id);
                return true;
            case R.id.delete:
                deleteBeer(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void editBeer(long id){
        Log.d("Edit beer","");
    }

    public void deleteBeer(long id){
        Log.d("Delete beer","");
    }


}