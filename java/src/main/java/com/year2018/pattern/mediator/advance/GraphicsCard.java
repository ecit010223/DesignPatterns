package com.year2018.pattern.mediator.advance;

/**
 * author：zyh
 * on: 2018/8/22 22:06
 */
public class GraphicsCard extends Colleague {
    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 播放视频
     * @param data
     */
    public void videoPlay(String data){
        System.out.println("视频："+data);
    }
}
