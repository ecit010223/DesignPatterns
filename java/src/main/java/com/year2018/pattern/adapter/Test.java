package com.year2018.pattern.adapter;

/**
 * Author: zyh
 * Date: 2018/8/29 14:10
 */
public class Test {
    public static void main(String[] args){
        VoltAdapter adapter = new VoltAdapter();
        System.out.println("输出电压："+adapter.getVolt5());
    }
}
