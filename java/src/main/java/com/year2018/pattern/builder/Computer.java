package com.year2018.pattern.builder;

/**
 * 作者：张玉辉 on 2018/7/31 21:01.
 */
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer(){}

    /** 设置主板 **/
    public void setBoard(String board){
        mBoard = board;
    }

    /** 设置显示器 **/
    public void setDisplay(String display){
        mDisplay = display;
    }

    /** 设置操作系统 **/
    public abstract void setOS();

    @Override
    public String toString() {
        return "Computer [mBoard="+mBoard+", mDisplay="+mDisplay+",mOS="+mOS+"]";
    }
}