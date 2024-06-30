package com.atguigu.git;


import java.util.*;

public class GitTest {
    public static void main(String[] args) {
        System.out.println("hello git");
        System.out.println("hello git2");
        System.out.println("hello git3");
        System.out.println("hello git4");
        System.out.println("master test!");
        System.out.println("hot-fix test!");
        System.out.println("push test");
        System.out.println("pull test");
        System.out.println("gitee test");
        System.out.println("gitee pull");
        Map<String,Object> map = new HashMap<>();
        for(int i = 0; i < 12;i++){
            map.put("key"+i,i);
        }
        map.put(null,null);
        Map<String,Object> table = new Hashtable<>();
        table.put("key1","value1");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10;i++){
            list.add("key"+i);
        }
        list.add("a");
        list.add("b");
        list.add("c");
        String[] strings = list.toArray(new String[]{});
        Arrays.stream(strings).forEach(System.out::println);
    }
}
