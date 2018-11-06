package com.year2018.effective_java.item03.enumoration;

/**
 * Author: zyh
 * Date: 2018/10/18 14:24
 * 实现Singleton的最佳方法
 */
public enum  Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
