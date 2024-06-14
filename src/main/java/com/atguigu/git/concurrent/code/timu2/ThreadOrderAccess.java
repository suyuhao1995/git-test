package com.atguigu.git.concurrent.code.timu2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class shareDataThree{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    Condition cd1 = lock.newCondition();
    Condition cd2 = lock.newCondition();
    Condition cd3 = lock.newCondition();
    public void print5(int total) {
        lock.lock();
        try {
            //判断
            while(num!=1) {
                cd1.await();
            }
            //干活
            for(int i=1;i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            //通知
            num = 2;
            cd2.signal();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(int total) {
        lock.lock();
        try {
            //判断
            while(num!=2) {
                cd2.await();
            }
            //干活
            for(int i=1;i<=10;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            //通知
            num = 3;
            cd3.signal();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(int total) {
        lock.lock();
        try {
            //判断
            while(num!=3) {
                cd3.await();
            }
            //干活
            for(int i=1;i<=15;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            //通知
            num = 1;
            cd1.signal();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 多线程之间按顺序调用,实现A->B->C
 * 三个线程启动,要求如下:
 * AA打印5次,BB打印10次,CC打印15次
 * 接着
 * AA打印5次,BB打印10次,CC打印15次
 * 来10轮
 * @author Administrator
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        shareDataThree shareDataThree = new shareDataThree();
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                shareDataThree.print5(i);
            }
        },"AA").start();
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                shareDataThree.print10(i);
            }
        },"BB").start();
        new Thread(()->{
            for(int i=1;i<=10;i++) {
                shareDataThree.print15(i);
            }
        },"CC").start();
    }
}

