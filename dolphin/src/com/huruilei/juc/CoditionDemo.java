package com.huruilei.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 备注；多个线程之间按照顺序调用，实现A->B->C
 * 三个线程启用，要求如下
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 */

class PrintDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        try {
            lock.lock();
            //判断
            while(number !=1){
                c1.await();
            }

            //干活
            for (int i =1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //唤醒
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        try {
            lock.lock();
            //判断
            while(number !=2){
                c2.await();
            }

            //干活
            for (int i =1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //唤醒
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        try {
            lock.lock();
            //判断
            while(number !=3){
                c3.await();
            }

            //干活
            for (int i =1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            //唤醒
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class CoditionDemo {
    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
        new Thread(()->{
            for (int i =0;i<10;i++){
                printDemo.print5();
            }
        },"A").start();

        new Thread(()->{
            for (int i =0;i<10;i++){
                printDemo.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i =0;i<10;i++){
                printDemo.print15();
            }
        },"C").start();
    }
}
