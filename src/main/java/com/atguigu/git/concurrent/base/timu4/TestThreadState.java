package com.atguigu.git.concurrent.base.timu4;

import static com.atguigu.git.concurrent.base.timu4.LoggerUtils.logger1;
import static com.atguigu.git.concurrent.base.timu4.LoggerUtils.main;

public class TestThreadState {
    static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
        testWaiting();
        //testNewRunnableTerminated();
        //testBlocked();
    }

    /*
        13:19:20.992 [t2] DEBUG A - before waiting
        13:19:26.036 [main] DEBUG G - state: RUNNABLE
        13:19:48.897 [main] DEBUG G - state: WAITING
        13:19:55.177 [main] DEBUG G - state: BLOCKED
        13:20:03.499 [main] DEBUG G - state: RUNNABLE
     */
    private static void testWaiting() {
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                logger1.debug("before waiting"); // 1
                try {
                    LOCK.wait(); // 3
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//8
        },"t2");

        t2.start();
        main.debug("state: {}", t2.getState()); // 2
        synchronized (LOCK) {
            main.debug("state: {}", t2.getState()); // 4
            LOCK.notify(); // 5
            main.debug("state: {}", t2.getState()); // 6
        }
        main.debug("state: {}", t2.getState()); // 7
    }

    /*
        13:06:09.445 [main] DEBUG G - state: RUNNABLE
        13:06:17.413 [t2] DEBUG A - before sync
        13:06:55.667 [main] DEBUG G - state: BLOCKED
        13:07:15.637 [t2] DEBUG A - in sync
        13:07:24.812 [main] DEBUG G - state: TERMINATED
     */
    private static void testBlocked() {
        Thread t2 = new Thread(() -> {
            logger1.debug("before sync"); // 3
            synchronized (LOCK) {//4.尝试获取锁
                logger1.debug("in sync"); // 6
            }
        },"t2");

        t2.start();
        main.debug("state: {}", t2.getState()); // 1
        synchronized (LOCK) {
            //2.进入代码块但不执行
            main.debug("state: {}", t2.getState()); // 5
        }
        main.debug("state: {}", t2.getState()); // 7
    }

    /*
        12:50:40.963 [main] DEBUG G - state: NEW
        12:50:46.181 [main] DEBUG G - state: RUNNABLE
        12:50:50.572 [t1] DEBUG A - running...
        12:50:55.676 [main] DEBUG G - state: TERMINATED
     */
    private static void testNewRunnableTerminated() {
        Thread t1 = new Thread(() -> {
            logger1.debug("running..."); // 3
        },"t1");

        main.debug("state: {}", t1.getState()); // 1
        t1.start();
        main.debug("state: {}", t1.getState()); // 2

        main.debug("state: {}", t1.getState()); // 4
    }
}
