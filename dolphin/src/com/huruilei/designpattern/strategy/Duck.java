package com.huruilei.designpattern.strategy;

/**
 * @author: huruilei
 * @date: 2019/10/30
 * @description: 鸭子类
 *      策略模式定义了算法族，分别封装起来，让它们之间可以互相替换
 *      此模式让算法的变化独立于使用算法的客户
 * @return
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public Duck(){}

    public abstract void display();

    public void fly(){
        flyBehavior.fly();
    }

    public void quack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("l`m swimming");
    }
}
