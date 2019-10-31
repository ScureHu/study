package com.huruilei.designpattern.strategy;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quck();
    }
    @Override
    public void display() {
        System.out.println("l'm model dock");
    }
}
