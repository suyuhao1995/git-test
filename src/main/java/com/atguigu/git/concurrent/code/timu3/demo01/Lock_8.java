package com.atguigu.git.concurrent.code.timu3.demo01;

import java.util.concurrent.TimeUnit;

class Phone{
	public synchronized void sendSMS(){
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

		}
		System.out.println("-------sendSMS");
	}
	public synchronized void sendEmail(){
		System.out.println("-------sendEmail");
	}
	public void getHello() {
		System.out.println("hello");
	}
}

/**
 *
 * @author Administrator
对象锁
-----------------------------------------------
 * 1.标准访问,先打印短信还是邮件? 短信
 * 2.停4秒在短信方法内,先打印短信还是邮件? 短信
 * 3.新增普通的hello方法,是先打短信还是hello? hello
 * 4.现在有两部手机,先打印短信还是邮件? 邮件
----------------------------------------------
类锁
-----------------------------------------------
 * 5.两个静态同步方法,1部手机,先打印短信还是邮件? 短信
 * 6.两个静态同步方法,2部手机,先打印短信还是邮件? 短信
-----------------------------------------------
对象锁和类锁
-----------------------------------------------
 * 7.1个静态同步方法,1个普通同步方法,1部手机,先打印短信还是邮件 邮件
 * 8.1个静态同步方法,1个普通同步方法,2部手机,先打印短信还是邮件 邮件
-----------------------------------------------
 */
public class Lock_8 {
	public static void main(String[] args) throws Exception {
		Phone phone = new Phone();
		Phone phone2 = new Phone();
		new Thread(()->{
			phone.sendSMS();
		},"AA").start();
		Thread.sleep(100);
		new Thread(()->{
			//phone.sendEmail();
			//phone.getHello();
			phone2.sendEmail();
		},"BB").start();		
	}
}
