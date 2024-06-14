package com.atguigu.git.concurrent.code.timu3.demo02;

import java.util.concurrent.TimeUnit;

class Phone{
	public void sendSMS(){
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println("-------sendSMS");
	}
	public void sendEmail(){
		System.out.println("-------sendEmail");
	}
}

public class Lock_8 {
	public static void main(String[] args) throws Exception {
		Phone phone = new Phone();
		Object lock = new Object();
		new Thread(()->{
			synchronized (lock){
				phone.sendSMS();
			}
		},"AA").start();
		Thread.sleep(100);
		new Thread(()->{
			synchronized (lock) {
				phone.sendEmail();
			}
		},"BB").start();		
	}
}
