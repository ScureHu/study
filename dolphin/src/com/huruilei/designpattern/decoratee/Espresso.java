package com.huruilei.designpattern.decoratee;

/**
 * @author: huruilei
 * @date: 2019/11/5
 * @description:
 * @return
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
