package com.huruilei.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class CurrentCoditionsDisplay2 implements Observer,DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    @Override
    public void display() {
        System.out.println("temperature : "+temperature+"humidity: "+humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = ((WeatherData2) o).getTemperature();
            this.humidity = ((WeatherData2) o).getHumidity();
            display();
        }
    }
}
