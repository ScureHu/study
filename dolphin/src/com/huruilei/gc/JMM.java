package com.huruilei.gc;

class MyNumber {
    volatile int number = 10;

    public void setNumber(int number) {
        this.number = number;
    }
}

public class JMM {

    public static void main(String[] args) {
        MyNumber number = new MyNumber();

        new Thread(()->{
            System.out.println("****coming in*****");
            number.setNumber(28);
            System.out.println(Thread.currentThread().getName()+"\t"+"current number is "+number.number);
        },"a").start();

        while (number.number == 10){

        }
        System.out.println(Thread.currentThread().getName()+"\t"+"main number is "+number.number);
    }
}
