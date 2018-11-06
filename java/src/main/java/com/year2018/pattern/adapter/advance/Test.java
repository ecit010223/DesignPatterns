package com.year2018.pattern.adapter.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:15
 */
public class Test {
    public static void main(String[] args){
        VoltAdapter adapter = new VoltAdapter(new Volt220());
        System.out.println("输出电压："+adapter.getVolt5());
    }
}
