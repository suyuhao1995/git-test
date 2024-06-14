package com.atguigu.git.concurrent.code.timu3.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket/* implements Runnable*/{
	private int number = 30;
	//1.��ϰSynchronized
	//��һ��:ͬ������
	/*	
	 public synchronized void sale() {
		//�ڶ���:ͬ�������
		synchronized (this) {
			
		}
		if(number > 0) {
			System.out.println(Thread.currentThread().getName()
					+"\t ����"+number--+"��Ʊ\t��ʣ"+number);
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
				+"\t ����"+number--+"��Ʊ\t��ʣ"+number);
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
		//ʵ��Runnable
		//��ʽһ:ticket��ʵ��runnable�ӿ�
		/*		 
		 	new Thread(ticket,"AA").start(); 
		 	new Thread(ticket, "BB").start();
		 	new Thread(ticket, "CC").start();
		 */
		//��ʽ��:�����ڲ���
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
		//��ʽ��:lamda���ʽ
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
