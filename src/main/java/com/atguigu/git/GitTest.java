package com.atguigu.git;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
        map.put("test","test");
    }
}
