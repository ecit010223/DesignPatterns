package com.year2018.concurrency.chapter03;

/**
 * Author: zyh
 * Date: 2018/11/9 8:35
 * 对于final域，编译器和处理器要遵守两个重排序规则：
 * 1）在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，
 * 这两个操作之间不能重排序。
 * 2）初次读一个包含final域的对象的引用，与随后初次读这个final域，这两个操作之间不能重排序。
 **/
public class FinalExample {
    int i;  //普通变量
    final int j;  //final变量
    static FinalExample obj;

    public FinalExample() { //构造函数
        i = 1; //写普通域
        // 写final域的重排序规则禁止把final域的写重排序到构造函数之外
        j = 2; //写final域
    }

    public static void writer() { //写线程A执行
        obj = new FinalExample();
    }

    public static void reader() { //读线程B执行
        FinalExample object = obj; //读对象引用
        int a = object.i; //读普通域
        int b = object.j; //读final域
    }
}
