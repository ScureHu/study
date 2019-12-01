package com.huruilei.gc;

public class JvmDemo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(maxMemory);
        System.out.println(totalMemory);
    }
}
