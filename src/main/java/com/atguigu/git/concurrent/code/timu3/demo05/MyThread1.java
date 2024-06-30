package com.atguigu.git.concurrent.code.timu3.demo05;

public class MyThread1 extends Thread{
    private Ticket ticket;

    public MyThread1(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.num > 0){
            synchronized (ticket){
                if(ticket.num > 0){
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket.num+"张票");
                    ticket.num--;
                }
            }
        }
    }
}
