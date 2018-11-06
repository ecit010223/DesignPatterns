package com.year2018.pattern.state;

/**
 * author：zyh
 * on: 2018/8/1 21:35
 * 电视状态接口，定义了电视操作的函数
 */
public interface TvState {
    void nextChannel();
    void preChannel();
    void turnUp();
    void turnDown();
}
