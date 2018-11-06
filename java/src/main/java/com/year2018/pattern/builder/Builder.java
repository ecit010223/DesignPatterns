package com.year2018.pattern.builder;

/**
 * 作者：张玉辉 on 2018/7/31 21:07.
 */
public abstract class Builder {
    /** 设置主机 **/
    public abstract void buildBoard(String board);
    /** 设置显示器 **/
    public abstract void buildDisplay(String display);
    /** 设置操作系统 **/
    public abstract  void buildOS();
    /** 创建Computer **/
    public abstract Computer create();
}
