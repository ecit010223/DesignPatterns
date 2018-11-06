package com.year2018.pattern.command;

/**
 * author：zyh
 * on: 2018/8/20 20:57
 * 接收者类：执行具体逻辑的角色
 */
public class Receiver {
    /**
     * 真正执行具体命令逻辑方法
     */
    public void action(){
        System.out.println("执行具体操作");
    }
}
