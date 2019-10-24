package com.huruilei.juc;

/**
 * @author: huruilei
 * @date: 2019/10/9
 * @description:
 * 题目:现在两个线程，可以操作初始值为零的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替，来十轮，变量初始值为零
 *
 * 1、高内聚低耦合前提下，线程操作资源类
 * 2、判断/干活/通知
 * 3、防止多线程的虚假唤醒
 * @return
 */
class Aircondition{
    private int number = 0;

    public synchronized void increment() throws Exception {
        //判断
        while (number != 0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
    public synchronized void decrement() throws Exception {
        //判断
        while (number == 0) {
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
}

public class ProdConsumerDemo {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
