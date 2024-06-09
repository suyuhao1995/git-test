package com.atguigu.git.javase.code.timu3.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //listIterator1();
        listIterator2();
        //listIterator3();
    }

    /**
     * 正确的方式
     */
    public static void listIterator3(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            if (2 == value) {
                it.remove();
            }

            System.out.println(value);
        }

        System.out.println("list=" + list.toString());
    }

    /*
       错误：
        java.util.ConcurrentModificationException
     */
    public static void listIterator2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int value : list) {
            if(2 == value){
                list.remove(Integer.valueOf(value));
            }
            System.out.println(value);
        }

        System.out.println("list=" + list.toString());
    }

    /*
     错误：
     结果显示只删除了一个2，另一个2被遗漏了，原因是：删除了第一个2后，集合里的元素个数减1，
     后面的元素往前移了1位，导致了第二个2被遗漏了。
     */
    private static void listIterator1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++) {
            if(2 == list.get(i)){
                list.remove(i);
            }
            System.out.println(list.get(i));
        }

        System.out.println("list=" + list.toString());
    }
}
