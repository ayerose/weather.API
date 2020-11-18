/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

/**
 *
 * @author Soreya
 */
public class WeatherInfo
{
    private String timestamp;
    private String temperature; 
    
    WeatherInfo(String timestamp, String temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        
        
    }
    
    public String  getTimestamp() {   // getters and setters da wir timestamp und temp auf private gesetzt haben
        return timestamp;
    }  
    public String getTemperature() {
        return temperature;
    }
    
    
}
