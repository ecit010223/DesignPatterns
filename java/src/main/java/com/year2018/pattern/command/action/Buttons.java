package com.year2018.pattern.command.action;

/**
 * author：zyh
 * on: 2018/8/20 21:17
 */
public class Buttons {
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private FallCommand fallCommand;
    private TransformCommand transformCommand;

    /**
     * 按下向左移动按钮
     */
    public void toLeft(){
        leftCommand.execute();
    }

    /**
     * 按下向右移动按钮
     */
    public void toRight(){
        rightCommand.execute();
    }

    /**
     * 按下向下移动按钮
     */
    public void fall(){
        fallCommand.execute();
    }

    /**
     * 按下变形按钮
     */
    public void transform(){
        transformCommand.execute();
    }

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setFallCommand(FallCommand fallCommand) {
        this.fallCommand = fallCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }
}
