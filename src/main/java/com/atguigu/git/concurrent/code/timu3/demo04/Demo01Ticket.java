package com.atguigu.git.concurrent.code.timu3.demo04;

/*
    模拟卖票案例
    创建3个线程,同时开启,对共享的票进行出售
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        RunnableImpl run1 = new RunnableImpl();
        RunnableImpl run2 = new RunnableImpl();
        System.out.println("run:"+run);//run:com.itheima.demo08.Synchronized.RunnableImpl@58ceff1
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}
