package com.year2018.pattern.chain_of_responsibility;

/**
 * author：zyh
 * on: 2018/8/20 20:13
 */
public class Client {
    public static void main(String[] args){
        // 构造一个ConcreteHandler1对象
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        // 构造一个ConcreteHandler2对象
        ConcreteHandler2 handler2 = new ConcreteHandler2();

        //设置handler1的下一个节点
        handler1.successor=handler2;
        //处理请求
        handler1.handleRequest("ConcreteHandler2");
    }
}
