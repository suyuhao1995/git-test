package com.atguigu.git.javase.code.timu1;

public class A extends B{
    public A(){
        System.out.println("子类A的构造函数");
    }

    static {
        System.out.println("子类A的中的静态代码块");
    }

    {
        System.out.println("子类A的中的非静态代码块 sya()1");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("A!");
        A a2 = new A();
        System.out.println("启动完成");
    }
}
