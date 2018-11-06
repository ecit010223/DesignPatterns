package com.year2018.pattern.composite;

/**
 * Author: zyh
 * Date: 2018/8/29 11:21
 */
public class Client {
    public static void main(String[] args){
        // 构造一个根节点
        Composite root = new Composite("Root");

        // 构造两个枝干节点
        Composite branch1 = new Composite("Branch1");
        Composite branch2 = new Composite("Branch2");

        // 构造两个叶子节点
        Leaf leaf1 = new Leaf("Leaf1");
        Leaf leaf2 = new Leaf("Leaf2");

        // 将叶子节点添加至枝干节点中
        branch1.addChild(leaf1);
        branch2.addChild(leaf2);

        // 将枝干节点添加至根节点中
        root.addChild(branch1);
        root.addChild(branch2);

        //执行方法
        root.doSomething();
    }
}
