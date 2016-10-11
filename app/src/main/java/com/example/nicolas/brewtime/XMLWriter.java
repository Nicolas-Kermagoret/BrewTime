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
    public void writeXMLToFile(ArrayList<Beer> beers){
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("beers");
            doc.appendChild(mainRootElement);
            for(Beer beer : beers){
                Element new_beer = doc.createElement("beer");

                Element new_beer_name = doc.createElement("beerName");
                Element new_beer_type = doc.createElement("type");
                Element new_beer_litres =doc.createElement("litres");

                new_beer_name.setTextContent(beer.getName());
                new_beer_type.setTextContent(beer.getType());
                new_beer_litres.setTextContent(beer.getType());

                new_beer.appendChild(new_beer_name);
                new_beer.appendChild(new_beer_type);
                new_beer.appendChild(new_beer_litres);

                mainRootElement.appendChild(new_beer);
                //mainRootElement.appendChild("beer");
                Log.d("Ajout  de la bière : ", beer.getName());
            }

            // append child elements to root element
            /*
            mainRootElement.appendChild(getCompany(doc, "1", "Paypal", "Payment", "1000"));
            mainRootElement.appendChild(getCompany(doc, "2", "eBay", "Shopping", "2000"));
            mainRootElement.appendChild(getCompany(doc, "3", "Google", "Search", "3000"));
            */
            // output DOM XML to console
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
