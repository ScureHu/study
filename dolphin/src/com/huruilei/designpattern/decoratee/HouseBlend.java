package com.huruilei.designpattern.decoratee;


/**
 * @author: huruilei
 * @date: 2019/11/5
 * @description:
 * @return
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return 0.89;
    }
}
