package com.year2018.pattern.command;

/**
 * author：zyh
 * on: 2018/8/20 21:04
 */
public class Client {
    public static void main(String[] args){
        //构造一个接收者对象
        Receiver receiver = new Receiver();

        //根据接收者对象构造一个命令对象
        Command command = new ConcreteCommand(receiver);

        //根据具体的对象构造请求对象
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
