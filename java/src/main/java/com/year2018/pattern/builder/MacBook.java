package com.year2018.pattern.builder;

/**
 * 作者：张玉辉 on 2018/7/31 21:06.
 */
public class MacBook extends Computer {
    protected MacBook(){}

    @Override
    public void setOS() {
        mOS = "Mac OS X 10.10";
    }
}
