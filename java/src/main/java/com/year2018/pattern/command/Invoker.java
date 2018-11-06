package com.year2018.pattern.command;

/**
 * author：zyh
 * on: 2018/8/20 21:02
 * 请求者类：调用命令对象执行具体的请求
 */
public class Invoker {
    /**
     * 持有一个对相应命令对象的引用
     */
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        //调用具体命令对象的相关方法，执行具体命令
        command.execute();
    }
}
