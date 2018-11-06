package com.year2018.effective_java.item03.serializable;

/**
 * Author: zyh
 * Date: 2018/10/18 14:18
 * 为了使利用这其中一种方法实现的Singleton类变成是可序列化的（Serializable），仅仅在声明中加上
 * “implements Serializable”是不够的。为了维护并保证Singleton，必须声明所有实例域是瞬时（transient）的，
 * 并提供一个readResolve方法。否则，每次反序列化一个序列化的实例时，都会创建一个新的实例，为了防止这种
 * 情况，要在Elvis类中加入下面的readResolve方法
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
    }
}
