package com.huruilei.designpattern.strategy;

/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public class QuackSilence implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<silence>>");
    }
}
