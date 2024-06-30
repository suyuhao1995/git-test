package com.atguigu.git.concurrent.base.timu18.demo04;

import static java.lang.Thread.sleep;

public class DeadlockSolution3 {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                System.out.println(Thread.currentThread().getName()+"-lock A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName()+"-lock B");
                    System.out.println(Thread.currentThread().getName()+"-操作...");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (A) {
                System.out.println(Thread.currentThread().getName()+"-lock A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName()+"-lock B");
                    System.out.println(Thread.currentThread().getName()+"-操作...");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
