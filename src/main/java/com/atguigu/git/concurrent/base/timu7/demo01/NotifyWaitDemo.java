package com.atguigu.git.concurrent.base.timu7.demo01;

class ShareDataOne{
	private int number = 0;
	public synchronized void incr() throws InterruptedException {
		//判断
		/* 错误写法:可能导致虚假唤醒	
		if(number != 0) {
			this.wait();
		}
		*/
		while(number != 0) {
			this.wait();
		}
		//干活
		number++;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		//通知
		this.notifyAll();
	}
	public synchronized void decr() throws InterruptedException {
		//判断
		/* 错误写法:可能导致虚假唤醒	
		if(number != 1) {
			this.wait();
		}
		*/
		while(number != 1) {
			this.wait();
		}
		number--;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		//通知
		this.notifyAll();		
	}
}

/**
 * 现在两个线程
 * 操作一个初始值为0的变量
 * 实现一个线程对变量增加1,一个线程对变量减少1
 * 交替,来10轮
 * 1。线程 操作 资源类
 * 2.高内聚低耦合
 * [1]判断
 * [2]干活
 * [3]通知
 * @author Administrator
 */
public class NotifyWaitDemo {
	public static void main(String[] args) {
		ShareDataOne shareDataOne = new ShareDataOne();
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					shareDataOne.incr();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"AA").start(); 
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					shareDataOne.decr();;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"BB").start();
		/**
		 * 改成4个线程,两个加,两个减 交替20轮
		 */
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					shareDataOne.incr();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"CC").start(); 
		new Thread(()->{
			for(int i = 1;i<=10;i++) {
				try {
					shareDataOne.decr();;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"DD").start();		
	}
}
