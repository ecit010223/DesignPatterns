package com.year2018.effective_java.item09;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: zyh
 * Date: 2018/10/19 9:13
 */
public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    // Broken - no hashCode method!

    /**
     * The worst possible legal hash function - never use
     * 如下的hashCode方法是合法的，因为它确保了相等的对象总是具有同样的散列码。但它也极为恶劣，因为它
     * 使得每个对象都具有同样的散列码。因此，每个对象都被映射到同一个散列桶中，使散列表退化为链表。它使
     * 得本该线性时间运行的程序变成了平方级时间的运行，对于规模很大的散列表而言，这会关系到散列表能否正
     * 常工作。
     * @return
     */
//    @Override
//    public int hashCode() {
//        return 42;
//    }


    // A decent hashCode method - Page 48
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + areaCode;
//        result = 31 * result + prefix;
//        result = 31 * result + lineNumber;
//        return result;
//    }

    // 如果一个类是不可变的，并且计算散列码的开销也比较大，就应该考虑把散列码缓存在对象内部，而不是
    // 每次请求的时候都重新计算散列码。如果觉得这种类型的大多数对象会被用做散列键，就应该在创建实例
    // 的时候计算散列码。否则，可以选择“延迟初始化”散列码，一直到hashCode被第一次调用的时候才初始化。
//    private volatile int hashCode;
//
//    @Override
//    public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = 17;
//            result = 31 * result + areaCode;
//            result = 31 * result + prefix;
//            result = 31 * result + lineNumber;
//            hashCode = result;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        // 当没有覆盖hashCode时，如下操作会返回null，因为两个相等的实例具有不相等的散列码，因此，put
        // 方法把电话号码对象存放在一个散列桶中，get方法却在另一个散列桶中查找这个电话号码。即使这两
        // 个实例正好被放在同一个散列桶中，get方法也必定会返回null，因为HashMap有一项优化，可以将与
        // 每个项相关联的散列码缓存起来，如果散列码不匹配，也不必检验对象的等同性。
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
