package com.year2018.pattern.observable;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * author：zyh
 * on: 2018/8/21 20:51
 */
public class Test {
    public static void main(String[] args){
        //被观察者
        DevTechFrontier devTechFrontier = new DevTechFrontier();
        //观察者
        Coder mrsimple = new Coder("mr.simple");
        Coder coder1 = new Coder("coder-1");
        Coder coder2 = new Coder("coder-2");
        Coder coder3 = new Coder("coder-3");

        //将观察者注册到可观察对象的观察列表中
        devTechFrontier.addObserver(mrsimple);
        devTechFrontier.addObserver(coder1);
        devTechFrontier.addObserver(coder2);
        devTechFrontier.addObserver(coder3);

        //发布消息
        devTechFrontier.postNewPublication("新消息发布");
    }
}
