package com.year2018.pattern.facade;

/**
 * Author: zyh
 * Date: 2018/8/29 16:35
 */
public class PhoneImpl implements Phone {
    @Override
    public void dial() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
