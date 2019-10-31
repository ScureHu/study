package com.huruilei.designpattern.strategy;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("l'm no fly");
    }
}
