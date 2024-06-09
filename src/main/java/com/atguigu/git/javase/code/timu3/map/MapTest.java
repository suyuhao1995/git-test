package com.atguigu.git.javase.code.timu3.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "test1");
        map.put("2", "test2");
        map.put("3", "test3");
        map.put("4", "test4");

        //完整遍历Map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("key: %s value:%s\r\n", entry.getKey(), entry.getValue());
        }

        //删除元素
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, String> entry= it.next();
            String key= entry.getKey();
            int k = Integer.parseInt(key);
            if(k%2==1)
            {
                System.out.printf("delete key:%s value:%s\r\n", key, entry.getValue());
                it.remove();
            }
        }

        //完整遍历Map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("key: %s value:%s\r\n", entry.getKey(), entry.getValue());
        }
    }
}
