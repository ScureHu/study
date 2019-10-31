package com.huruilei.designpattern.strategy;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class Quck implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
