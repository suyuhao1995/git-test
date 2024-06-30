package com.atguigu.git.concurrent.base.timu18.demo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class DeadlockSolution2 {
    Lock A = new ReentrantLock();
    Lock B = new ReentrantLock();
    public static void main(String[] args) {
        DeadlockSolution2 deadlockSolution2 = new DeadlockSolution2();
        deadlockSolution2.lockTest();
    }

    public void lockTest() {
        Thread t1 = new Thread(() -> {
            A.lock();
            System.out.println(Thread.currentThread().getName()+"-lock A");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                if(B.tryLock()){
                    try{
                        System.out.println(Thread.currentThread().getName()+"-lock B");
                        System.out.println(Thread.currentThread().getName()+"-操作...");
                    }finally {
                        B.unlock();
                    }
                }
            }finally {
                A.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            B.lock();
            System.out.println(Thread.currentThread().getName()+"-lock B");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                if(A.tryLock()){
                    try{
                        System.out.println(Thread.currentThread().getName()+"-lock A");
                        System.out.println(Thread.currentThread().getName()+"-操作...");
                    }finally {
                        A.unlock();
                    }
                }
            }finally {
                B.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
