package com.naruto.dao.test;


import java.util.concurrent.ConcurrentHashMap;

public class TestCpu {

    public String test(){
        int i = 2;
        while (i > 0){
            new Thread(this::testTrue).start();
            i--;
        }
        return "执行成功";
    }

    public ConcurrentHashMap map = new ConcurrentHashMap();
    public void testTrue(){
        while (true){
            int i = 200000;
            while (i > 0){
                map.put(Thread.currentThread().getName() + i, i);
                i--;
            }
            System.out.println(map.size());
        }
    }

    public static void main(String[] args) {
        TestCpu rest = new TestCpu();
        rest.test();
    }
}
