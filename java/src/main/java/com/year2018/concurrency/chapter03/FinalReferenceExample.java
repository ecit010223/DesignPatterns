package com.year2018.concurrency.chapter03;

/**
 * Author: zyh
 * Date: 2018/11/9 8:36
 * 在构造函数内对一个final引用的对象的成员域的写入，与随后在构造函数外把这个被构造对象的引用赋值
 * 给一个引用变量，这两个操作之间不能重排序。
 */
public class FinalReferenceExample {
    final int[] intArray; //final是引用类型
    static FinalReferenceExample obj;

    public FinalReferenceExample() { //构造函数
        intArray = new int[1]; //1
        intArray[0] = 1; //2
    }

    public static void writerOne() { //写线程A执行
        obj = new FinalReferenceExample(); //3
    }

    public static void writerTwo() { //写线程B执行
        obj.intArray[0] = 2; //4
    }

    public static void reader() { //读线程C执行
        if (obj != null) { //5
            int temp1 = obj.intArray[0]; //6
        }
    }
}
