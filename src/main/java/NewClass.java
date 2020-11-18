import java.util.Scanner;
import weather.WeatherFetcher;
import weather.WeatherInfo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soreya
 */
public class NewClass{

    public static void main (String []args) throws Exception {
        
        System.out.println("For what city would you like to display the weather?");
        
        Scanner input = new Scanner(System.in);
        String city = input.next();
        
        System.out.println("Checking weather for the city:" + city);
        
        
        
        WeatherFetcher w = WeatherFetcher.getInstance();
        
        WeatherInfo[] weatherInfos =  w.fetch(city);
        
        for (int x = 0; x < weatherInfos.length; x++) {
            WeatherInfo weatherInfo = weatherInfos[x];
            
            System.out.println(weatherInfo.getTimestamp()+ ": " +weatherInfo.getTemperature());
            
        }
        
      
    }
}
 