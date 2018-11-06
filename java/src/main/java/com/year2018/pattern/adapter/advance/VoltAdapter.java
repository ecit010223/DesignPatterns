package com.year2018.pattern.adapter.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:12
 * 对象适配器模式
 */
public class VoltAdapter implements FiveVolt {
    Volt220 mVolt220;

    public VoltAdapter(Volt220 adapter){
        mVolt220 = adapter;
    }

    public int getVolt220(){
        return mVolt220.getVolt220();
    }

    @Override
    public int getVolt5() {
        return 5;
    }
}
