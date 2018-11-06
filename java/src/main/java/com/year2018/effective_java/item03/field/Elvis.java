package com.year2018.effective_java.item03.field;

/**
 * Author: zyh
 * Date: 2018/10/18 14:08
 * Singleton方式一缺点：享有特权的客户端可以借助AccessibleObject.setAccessible方法，通过反射机制调用私
 * 有构造器，如果需要抵御这种攻击，可以修改构造器，让它在被要求创建第二个实例的时候抛出异常。见method包
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
