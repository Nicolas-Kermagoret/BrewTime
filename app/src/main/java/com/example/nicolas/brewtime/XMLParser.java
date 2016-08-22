package com.example.nicolas.brewtime;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nicolas on 02/01/16.
 */
public class XMLParser extends Activity {

    private ArrayList<Beer> beers;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //beerTextView = (TextView) findViewById(R.id.BeerTextView);
        Log.d("TEST", "onCreate");


    }

    public ArrayList<Beer> getBeers() {
        return beers;
    }

    public void parse(XmlPullParser parser){

        XmlPullParserFactory pullParserFactory;
        try {
            // pullParserFactory = XmlPullParserFactory.newInstance();
            // XmlPullParser parser = getResources().getXml(R.xml.beers);

            parseXML(parser);

        } catch (XmlPullParserException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("TEST", "in onCreate() XMLParser");

    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        Log.d("DEBUG", "in parseXML");
        this.beers = new ArrayList<Beer>();
        int eventType = parser.getEventType();
        Beer currentBeer = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    //Log.d("TEST", "START_DOCUMENT");
                    beers = new ArrayList<Beer>();
                    break;
                case XmlPullParser.START_TAG:
                    //Log.d("TEST", "START_TAG");
                    name = parser.getName();
                    if (name.equals("beer")){
                        Log.d("TEST", "New Beer");
                        currentBeer = new Beer();
                    } else if (currentBeer != null){
                        if (name.equals("beerName")){
                            currentBeer.setName(parser.nextText());
                        } else if (name.equals("type")){
                            currentBeer.setType(parser.nextText());
                        } else if (name.equals("litres")){
                            currentBeer.setQuantity(parser.nextText());
                        } else if (name.equals("brassage")){
                            currentBeer.setBrassage(parser.nextText());
                        }else if (name.equals("secondaire")){
                            currentBeer.setSecondaire(parser.nextText());
                        }else if (name.equals("garde")){
                            currentBeer.setGarde(parser.nextText());
                        }else if (name.equals("embouteillage")){
                            currentBeer.setEmbouteillage(parser.nextText());
                        }else if (name.equals("degustation")){
                            currentBeer.setDegustation(parser.nextText());
                        }else if (name.equals("malt")){
                            parser.next();
                            currentBeer.getMalts().add(parser.nextText());
                            parser.next();
                            currentBeer.getMaltsQuantity().add(parser.nextText());
                        }else if (name.equals("houblonAm")){
                            parser.next();
                            currentBeer.getHoublonsAmer().add(parser.nextText());
                            parser.next();
                            currentBeer.getHoublonsAmerQuantity().add(parser.nextText());
                        }else if (name.equals("houblonAr")){
                            parser.next();
                            currentBeer.getHoublonsArome().add(parser.nextText());
                            parser.next();
                            currentBeer.getHoublonsAromeQuantity().add(parser.nextText());
                        }else if (name.equals("epice")){
                            parser.next();
                            currentBeer.getEpices().add(parser.nextText());
                            parser.next();
                            currentBeer.getEpicesQuantity().add(parser.nextText());
                        }else if (name.equals("levure")){
                            parser.next();
                            currentBeer.getEpices().add(parser.nextText());
                            parser.next();
                            currentBeer.getEpicesQuantity().add(parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    //Log.d("TEST", "END XML");
                    if (name.equalsIgnoreCase("beer") && currentBeer != null){
                        Log.d("TEST", "Adding beer");
                        beers.add(currentBeer);
                    }
            }
            eventType = parser.next();
        }

        //printBeers(beers);
    }

    private void printBeers(ArrayList<Beer> beers)
    {

        TextView display = (TextView)findViewById(R.id.beer_type);
        display.setText(beers.get(0).getType());

    }


}
