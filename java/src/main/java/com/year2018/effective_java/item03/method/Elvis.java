package com.year2018.effective_java.item03.method;

/**
 * Author: zyh
 * Date: 2018/10/18 14:11
 * 公有域方法的主要好处在于，组成类的成员的声明很清楚地表明了这个类是一个Singleton，公有的静态域是final
 * 的，所以该域将总是包含相同的对象引用。公有域方法在性能上不再有任何优势：现代的JVM实现几乎都能够将静
 * 态工厂方法的的调用内联化。
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
