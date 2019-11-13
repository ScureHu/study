package com.huruilei.designpattern.decoratee;

/**
 * @author: huruilei
 * @date: 2019/11/5
 * @description:
 * @return
 */
public abstract class Beverage {
    String description ="Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
