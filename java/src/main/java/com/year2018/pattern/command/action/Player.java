package com.year2018.pattern.command.action;

/**
 * author：zyh
 * on: 2018/8/20 21:20
 */
public class Player {

    public static void main(String[] args){
        TetrisMachine machine = new TetrisMachine();

        //根据游戏构造四种命令
        LeftCommand leftCommand = new LeftCommand(machine);
        RightCommand rightCommand = new RightCommand(machine);
        FallCommand fallCommand = new FallCommand(machine);
        TransformCommand transformCommand = new TransformCommand(machine);

        //按钮可以执行不同的命令
        Buttons buttons = new Buttons();
        buttons.setLeftCommand(leftCommand);
        buttons.setRightCommand(rightCommand);
        buttons.setFallCommand(fallCommand);
        buttons.setTransformCommand(transformCommand);

        //具体按下哪个按钮玩家说了算
        buttons.toLeft();
        buttons.toRight();
        buttons.fall();
        buttons.transform();
    }
}
