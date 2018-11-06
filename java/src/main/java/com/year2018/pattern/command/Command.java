package com.year2018.pattern.command;

/**
 * author：zyh
 * on: 2018/8/20 20:58
 * 抽象命令接口
 * 在接收者和命令执行的具体行为之间加以弱耦合
 */
public interface Command {
    /**
     * 执行具体操作的命令
     */
    void execute();
}
