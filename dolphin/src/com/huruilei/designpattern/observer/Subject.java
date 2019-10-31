package com.huruilei.designpattern.observer;


/**
 * @author: huruilei
 * @date: 2019/10/31
 * @description:
 * @return
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
