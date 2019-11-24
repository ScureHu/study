package com.huruilei.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable来实现futureTask
 * futureTask实现来Runnable接口
 */
class CallableImpl implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("l'm in");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableImpl());

        new Thread(futureTask,"b").start();

        Integer result = futureTask.get();
        System.out.println(result);

    }
}
