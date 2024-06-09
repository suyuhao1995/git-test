package com.atguigu.git.javase.code.timu2.code1;

import java.util.concurrent.CountDownLatch;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        String s1 = new StringBuilder().append("ja").append("va1").toString();
        String ss1 = s1.intern();
        System.out.println(ss1 == s1);
        String s2 = new String("java2");
        String ss2 = s2.intern();
        System.out.println(ss2 == s2);
        StringBuilder stringBuilder = new StringBuilder();
        CountDownLatch cd = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0 ; j < 200; j++){
                    stringBuilder.append("a");
                }
                cd.countDown();
            },String.valueOf(i)).start();
        }
        cd.await();
        System.out.println(stringBuilder.length());
    }
}
