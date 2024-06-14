package com.atguigu.git.concurrent.code.timu3.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket/* implements Runnable*/{
	private int number = 30;
	//1.复习Synchronized
	//第一种:同步方法
	/*	
	 public synchronized void sale() {
		//第二种:同步代码块
		synchronized (this) {
			
		}
		if(number > 0) {
			System.out.println(Thread.currentThread().getName()
					+"\t 卖出"+number--+"号票\t还剩"+number);
	    }
	 }
	 */
	//2.lock
	private Lock lock = new ReentrantLock();
	public void sale() {
		lock.lock();
		try {
			if(number>0) {
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName()
				+"\t 卖出"+number--+"号票\t还剩"+number);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	/*	
	@Override
	public void run() {
		while(number>0) {
			sale();
		}
	}
	*/	
}

public class SaleTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		//实现Runnable
		//方式一:ticket类实现runnable接口
		/*		 
		 	new Thread(ticket,"AA").start(); 
		 	new Thread(ticket, "BB").start();
		 	new Thread(ticket, "CC").start();
		 */
		//方式二:匿名内部类
		/*		
 		new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i=1;i<=40;i++) {
					ticket.sale();
				}
			}
		},"AA").start();
		new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i=1;i<=40;i++) {
					ticket.sale();
				}
			}
		},"BB").start();		
		new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i=1;i<=40;i++) {
					ticket.sale();
				}
			}
		},"CC").start();	
		*/			
		//方式三:lamda表达式
		new Thread(()->{for(int i=1;i<=40;i++) {
			ticket.sale();
		}},"AA").start(); 
		new Thread(()->{for(int i=1;i<=40;i++) {
			ticket.sale();
		}},"BB").start(); 
		new Thread(()->{for(int i=1;i<=40;i++) {
			ticket.sale();
		}},"CC").start(); 		
	}
}
