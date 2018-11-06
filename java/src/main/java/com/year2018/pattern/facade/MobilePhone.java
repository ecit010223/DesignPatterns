package com.year2018.pattern.facade;

/**
 * Author: zyh
 * Date: 2018/8/29 16:33
 */
public class MobilePhone {
    private Phone phone = new PhoneImpl();
    private Camera camera = new SamsungCamera();

    public void dial(){
        phone.dial();
    }

    public void videoChat(){
        System.out.println("--> 视频聊天接通中");
        camera.open();
        phone.dial();
    }

    public void hangup(){
        phone.hangup();
    }

    public void takePicture(){
        camera.open();
        camera.takePicture();
    }

    public void closeCamera(){
        camera.close();
    }
}
