package com.year2018.pattern.command.action;

import com.year2018.pattern.command.Command;

/**
 * author：zyh
 * on: 2018/8/20 21:13
 */
public class LeftCommand implements Command {
    /**
     * 持有一个接收者俄罗斯方块游戏对象的引用
     */
    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        //调用游戏机里的具体方法执行操作
        machine.toLeft();
    }
}
