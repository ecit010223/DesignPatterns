package com.year2018.pattern.facade;

/**
 * Author: zyh
 * Date: 2018/8/29 16:36
 */
public class SamsungCamera implements Camera {
    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePicture() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}
