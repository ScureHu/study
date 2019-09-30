package com.huruilei.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author: huruilei
 * @date: 2019/9/30
 * @description:
 * 8 锁
 * 1、标准访问，请问打印邮件还是短信 邮件
 * 2、暂停4秒钟在邮件方法中，请问打印邮件还是短信 短信
 * 3、新增普通sayHello方法，请问先打印邮件还是hello hello
 * 4、两部手机，请问打印邮件还是短信 短信
 * 5、两个静态同步方法，同一部手机，请问打印邮件还是短信 不清出
 * 6、两个静态同步方法，2部手机，请问打印邮件还是短信 邮件
 * 7、1个静态同步方法，1部手机，请问打印邮件还是短信 错
 * 8、1个静态同步方法，2部手机，请问打印邮件还是短信 错
 * @return
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone2.sendSMS();},"B").start();
    }
}
class Phone{
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("*****sendEmail");
    }

    public synchronized void sendSMS(){
        System.out.println("******sendSMS");
    }

    public void sayHey(){
        System.out.println("*****sendHey");
    }
}
