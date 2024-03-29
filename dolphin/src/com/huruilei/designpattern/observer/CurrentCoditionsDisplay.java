package com.huruilei.designpattern.observer;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class CurrentCoditionsDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentCoditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity +"%humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
