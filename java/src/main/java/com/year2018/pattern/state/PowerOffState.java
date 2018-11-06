package com.year2018.pattern.state;

/**
 * author：zyh
 * on: 2018/8/1 21:36
 * 关机状态，此时只有开机功能是效的
 */
public class PowerOffState implements TvState {

    @Override
    public void nextChannel() {

    }

    @Override
    public void preChannel() {

    }

    @Override
    public void turnUp() {

    }

    @Override
    public void turnDown() {

    }
}
