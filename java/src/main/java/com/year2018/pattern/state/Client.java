package com.year2018.pattern.state;

/**
 * author：zyh
 * on: 2018/8/1 21:44
 */
public class Client {

    public static void main(String[] args){
        TvController tvController = new TvController();
        //设置开机状态
        tvController.powerOn();
        //下一频道
        tvController.nextChannel();
        // 调高音量
        tvController.turnUp();
        // 设置关机状态
        tvController.powerOff();
        //调高音量，此时不会生效
        tvController.turnUp();
  }
}
