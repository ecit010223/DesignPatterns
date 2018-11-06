package com.year2018.pattern.mediator.advance;

/**
 * author：zyh
 * on: 2018/8/22 22:00
 */
public class CPU extends Colleague {
    private String dataVideo,dataSound;

    public CPU(Mediator mediator) {
        super(mediator);
    }

    public String getDataVideo(){
        return dataVideo;
    }

    public String getDataSound(){
        return dataSound;
    }

    public void decodeData(String data){
        //分割音、视频数据
        String[] tmp = data.split(",");
        //解析音、视频数据
        dataVideo = tmp[0];
        dataSound = tmp[1];
        //告诉中介者自身状态改变
        mediator.changed(this);
    }
}
