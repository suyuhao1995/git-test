package com.atguigu.git.concurrent.code.timu3.demo05;

public class Demo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new MyThread1(ticket).start();
        new MyThread1(ticket).start();

    }
}
