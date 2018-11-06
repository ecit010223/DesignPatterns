package com.year2018.pattern.state;

/**
 * author：zyh
 * on: 2018/8/1 21:41
 */
public class TvController implements PowerController {
    TvState mTvState;

    public void setTvState(TvState tvState){
        this.mTvState = tvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOnState());
        System.out.println("关机啦");
    }

    public void nextChannel(){
        mTvState.nextChannel();
    }

    public void preChannel(){
        mTvState.preChannel();
    }

    public void turnUp(){
        mTvState.turnUp();
    }

    public void turnDown(){
        mTvState.turnDown();
    }
}
