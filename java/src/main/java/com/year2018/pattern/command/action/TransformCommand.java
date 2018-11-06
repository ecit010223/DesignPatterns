package com.year2018.pattern.command.action;

import com.year2018.pattern.command.Command;

/**
 * author：zyh
 * on: 2018/8/20 21:17
 */
public class TransformCommand implements Command {
    /**
     * 持有一个接收者俄罗斯方块游戏对象的引用
     */
    private TetrisMachine machine;

    public TransformCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        this.machine.transform();
    }
}
