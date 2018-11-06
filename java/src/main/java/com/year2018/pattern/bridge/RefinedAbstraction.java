package com.year2018.pattern.bridge;

/**
 * Author: zyh
 * Date: 2018/8/29 16:49
 * 抽象部分的具体实现，该类一般是对抽象部分的方法进行完善和扩展。
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    /**
     * 对父类抽象部分中的方法进行扩展
     */
    public void refinedOperation(){
        // 对Abstraction中的方法进行扩展
    }
}
