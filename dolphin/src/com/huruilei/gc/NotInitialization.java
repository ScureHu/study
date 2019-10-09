package com.huruilei.gc;

/**
 * @author: huruilei
 * @date: 2019/10/9
 * @description:
 * <p>对于静态字段，只有直接定义这个字段的类才会被初始化
 * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化
 * 而不会触发子类的初始化。</p>
 *
 * <p>通过数组定义来的引用类，不会触发此类的初始化</p>
 *
 * <p>常量在编译阶段会存入调用类的常量池中，本质上
 * 并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化</p>
 * @return
 */
class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 23;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}

class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORD = "hello world";
}
public class NotInitialization{
    public static void main(String[] args) {
        //System.out.println(SuperClass.value);
        //SuperClass[] sca = new SuperClass[10];
        System.out.println(ConstClass.HELLOWORD);
    }
}
