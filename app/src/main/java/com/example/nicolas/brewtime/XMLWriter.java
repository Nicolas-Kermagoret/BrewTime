package com.example.nicolas.brewtime;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by mathieu on 11/10/16.
 */

public class XMLWriter {
    public void writeXMLToFile(Beer beer){
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("beers");
            doc.appendChild(mainRootElement);

            Element new_beer = doc.createElement("beer");

            Element new_beer_name = doc.createElement("beerName");
            Element new_beer_type = doc.createElement("type");
            Element new_beer_litres =doc.createElement("litres");
            Element new_beer_dates =doc.createElement("dates");
            Element new_beer_ingredients = doc.createElement("ingredients");

            Element date_brassage = doc.createElement("brassage");
            Element date_secondaire = doc.createElement("secondaire");
            Element date_garde = doc.createElement("garde");
            Element date_embouteillage = doc.createElement("embouteillage");
            Element date_degustation = doc.createElement("degustation");

            new_beer_name.setTextContent(beer.getName());
            new_beer_type.setTextContent(beer.getType());
            new_beer_litres.setTextContent(beer.getType());

            date_brassage.setTextContent(beer.getBrassage());
            date_secondaire.setTextContent(beer.getSecondaire());
            date_garde.setTextContent(beer.getGarde());
            date_embouteillage.setTextContent(beer.getEmbouteillage());
            date_degustation.setTextContent(beer.getDegustation());

            new_beer_dates.appendChild(date_brassage);
            new_beer_dates.appendChild(date_secondaire);
            new_beer_dates.appendChild(date_garde);
            new_beer_dates.appendChild(date_embouteillage);
            new_beer_dates.appendChild(date_degustation);

            new_beer.appendChild(new_beer_name);
            new_beer.appendChild(new_beer_type);
            new_beer.appendChild(new_beer_litres);
            new_beer.appendChild(new_beer_dates);

            for(Ingredient ing : beer.getIngredients()){
                Element new_ing = doc.createElement(ing.getType());
                Element new_ing_name = doc.createElement("name");
                Element new_ing_quantity = doc.createElement("quantity");

                new_ing_name.setTextContent(ing.getName());
                new_ing_quantity.setTextContent(Integer.toString(ing.getQuantity()));
                new_ing.appendChild(new_ing_name);
                new_ing.appendChild(new_ing_quantity);

                new_beer_ingredients.appendChild(new_ing);
            }

            new_beer.appendChild(new_beer_ingredients);
            mainRootElement.appendChild(new_beer);
            Log.d("Ajout  de la bière : ", beer.getName());

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

            System.out.println("\nXML DOM Created Successfully..");
            //*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
