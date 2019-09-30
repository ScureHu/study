package com.huruilei.juc;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: huruilei
 * @date: 2019/9/30
 * @description:
 * 三个售票员 卖出 30张票
 * 企业级代码多线程代码
 * 1、在高内聚低耦合的前提下，线程    操作     资源类
 * 空调的例子
 * @return
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{for (int i = 0;i<30;i++){ticket.sale();}},"A").start();
        new Thread(()->{for (int i = 0;i<30;i++){ticket.sale();}},"B").start();
        //高并发使用的集合类型
        List list = new CopyOnWriteArrayList();
        Set set = new CopyOnWriteArraySet();
        Map map = new ConcurrentHashMap();
    }
}

class Ticket{
    private static int TICKET_NUM = 30;
    Lock lock = new ReentrantLock();
    public void sale(){
        try {
            lock.lock();
            if(TICKET_NUM>0){
                System.out.println(Thread.currentThread().getName()+":Now Time Ticket have :"+(TICKET_NUM--)+" surplus ticket:"+TICKET_NUM);
            }
        }catch (Exception e){
            throw e;
        }finally {
            lock.unlock();
        }
    }
}
