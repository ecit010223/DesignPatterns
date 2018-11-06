package com.year2018.effective_java.item36;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/26 10:30
 */
public class Bigamy {
    private final char first;
    private final char second;

    public Bigamy(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Bigamy b) {
        return b.first == first && b.second == second;
    }

    // 正确的写法
//    @Override
//    public boolean equals(Object o){
//        if(!(o instanceof Bigamy)){
//            return false;
//        }
//        Bigamy b = (Bigamy)o;
//        return b.first==first&&b.second == second;
//    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigamy> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigamy(ch, ch));
        // 集合不能包含重复，但输出的值不是26，而是260。原因是equals没有覆盖，而是将它重载了。
        // 为了覆盖Object.equals，必须定义一个参数为Object类型的equals方法，但Bigamy的equals方法的参数
        // 并不是Object类型，因此Bigamy从Object继承了equals方法，这个equals方法测试对象的的同一性，就像
        // ==操作符一样。每个Bigamy的10个备份中，每一个都与其余的9个不同，因此Object.equals认为它们不相
        // 等，这正解释了程序为什么会打印出260的原因。
        System.out.println(s.size());
    }
}
