package com.huruilei.designpattern.observer;

import java.util.Observable;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class WeatherData2 extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData2(){

    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
