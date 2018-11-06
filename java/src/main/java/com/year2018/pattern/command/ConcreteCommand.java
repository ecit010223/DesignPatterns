package com.year2018.pattern.command;

/**
 * author：zyh
 * on: 2018/8/20 21:00
 */
public class ConcreteCommand implements Command {
    /** 持有一个对接收者对象的引用 **/
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //调用接收者的相关方法来执行具体逻辑
        receiver.action();
    }
}
