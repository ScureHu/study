package com.huruilei.designpattern.observer;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class WeatherSation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCoditionsDisplay coditionsDisplay = new CurrentCoditionsDisplay(weatherData);
        
    }
}
