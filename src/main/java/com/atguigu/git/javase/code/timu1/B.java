package com.atguigu.git.javase.code.timu1;

public class B {

    public B(){
        System.out.println("父类B的构造函数");
    }

    static {
        System.out.println("父类B的中的静态代码块");
    }

    {
        System.out.println("父类B的中的非静态代码块 sya()");
    }
}
