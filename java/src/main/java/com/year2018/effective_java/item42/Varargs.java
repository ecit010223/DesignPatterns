package com.year2018.effective_java.item42;

/**
 * Author: zyh
 * Date: 2018/11/1 11:04
 */
public class Varargs {
    /**
     * Simple use of varargs - Page 197
     */
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    /**
     * The WRONG way to use varargs to pass one or more arguments! - Page 197
     * 如果客户端没有传递参数，如下定义就会有问题
     */
//    static int min(int... args) {
//        if (args.length == 0)
//            throw new IllegalArgumentException("Too few arguments");
//        int min = args[0];
//        for (int i = 1; i < args.length; i++)
//            if (args[i] < min)
//                min = args[i];
//        return min;
//    }

    /**
     * The right way to use varargs to pass one or more arguments - Page 198
     * 上面min方法的优化
     */
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
