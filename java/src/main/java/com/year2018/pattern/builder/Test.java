package com.year2018.pattern.builder;

/**
 * author：zyh
 * on: 2018/7/31 21:20
 */
public class Test {
    public static void main(String[] args){
        //构建器
        Builder builder = new MacBookBuilder();
        //Director
        Director pcDirector = new Director(builder);
        //封装过程
        pcDirector.construct("英特尔主板","Retina显示器");
        //构建计算机，输出相关信息
        System.out.println("Computer Info:"+builder.create().toString());
    }
}
