package com.atguigu.git.javase.code.timu4;

class ShareDataOne{
    private int number = 0;
    public synchronized void print1() throws InterruptedException {
        //判断
        while(number % 2 != 0) {
            this.wait();
        }
        //干活
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        number++;
        //通知
        this.notifyAll();
    }
    public synchronized void print2() throws InterruptedException {
        //判断
        while(number % 2 == 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        number++;
        //通知
        this.notifyAll();
    }
}
public class NotifyWaitDemo {
    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(()->{
            for(int i = 1;i<=101;i++) {
                try {
                    shareDataOne.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for(int i = 1;i<=100;i++) {
                try {
                    shareDataOne.print2();;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
