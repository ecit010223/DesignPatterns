package com.year2018.effective_java.item27;

/**
 * Author: zyh
 * Date: 2018/10/24 14:47
 */
public class GenericSingletonFactory {
    // Generic singleton factory pattern
    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        public Object apply(Object arg) {
            return arg;
        }
    };

    // 因为UnaryFunction<Object>对于每个T来说并非都是个UnaryFunction<T>，所以产生了一条未受检的转换
    // 警告。但是恒等函数很特殊：它返回未被修改的参数，因此知道无论T的值是什么，用它作为UnaryFunction<T>
    // 都是类型安全的，因此，可以放心地禁止由这个转换所产生的未受检转换警告。
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}
