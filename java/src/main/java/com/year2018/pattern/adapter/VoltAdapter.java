package com.year2018.pattern.adapter;

/**
 * Author: zyh
 * Date: 2018/8/29 14:09
 * Adapter角色，将220V的电压转换成5V的电压
 */
public class VoltAdapter extends Volt220 implements FiveVolt {
    @Override
    public int getVolt5() {
        return 5;
    }
}
