/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;
        
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author Soreya
 */
public class WeatherFetcher { 
    
    private static WeatherFetcher instance;
    
    private WeatherFetcher () {
        
        
    }
    
    
    public static WeatherFetcher getInstance() {
        
        if (instance ==null) {
        instance = new WeatherFetcher();
    }
        return instance;
    
} 
    public WeatherInfo [] fetch(String city) throws Exception {   
        
        
      
        
        String uri = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=xml&appid=93e64bae367220809d5d473d6e73dd27";
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // wir holen uns ein neues Dokument
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        
        Document document = documentBuilder.parse(uri);
        
        //da uns nur die time elements interessieren, da sie das wetter beinhalten, nutzen wir den tag TIME
        NodeList times =  document.getElementsByTagName("time");
        
        WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];  // array anlegen wo man infos storen kann
                
        
            
        for (int x = 0; x < times.getLength(); x++); {
            int x = 0; // selber hinzugefügt, sonst error
         Node time = times.item(x);
         NamedNodeMap timeAttributes = time.getAttributes();
         
         String timestamp = (timeAttributes.getNamedItem("from").getNodeValue());
         
         
         NodeList children =  time.getChildNodes(); // die nodelist children represents die xml elements unter dem Tag TIME
         
         // wir müssen nun die nodelist durchgehen bis wir das temperature element gefunden haben:
         
         for (int y = 0 ; y < children.getLength(); y++) {
             Node child = children.item(y);  // child sind die jeweiligen Elemente unter dem parent tag TIME
             if (child.getNodeName() == "temperature") {      //  wenn wir den TEMPERATURE  tag/element erreicht haben
              String temperature =  child.getAttributes().getNamedItem("value").getNodeValue();
              
              //   double inum = Integer.parseInt(temperature);
               //  double  celsius = inum - formular;
                 
              //  celsius = inum - formular;
              
              weatherInfos[x] = new WeatherInfo(timestamp, temperature);
                 
               
       } 
      }
        
     }
        
        return weatherInfos;
      
    }

    
}
        
    
    

