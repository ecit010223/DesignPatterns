package com.year2018.pattern.mediator.advance;

/**
 * author：zyh
 * on: 2018/8/22 22:07
 */
public class SoundCard extends Colleague {

    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 播放音频
     * @param data
     */
    public void soundPlay(String data){
        System.out.println("音频："+data);
    }
}
