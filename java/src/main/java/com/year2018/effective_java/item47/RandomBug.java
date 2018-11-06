package com.year2018.effective_java.item47;

import java.util.Random;

/**
 * Author: zyh
 * Date: 2018/11/1 16:24
 */
public class RandomBug {
    private static final Random rnd = new Random();

    /**
     * 该方法有三个缺点：
     * 1.如果n是一个比较小的2的乘方，经过一段相当短的周期之后，它产生的随机数序列将会重复；
     * 2.如果n不是2的乘方，那么平均起来，有些数会比其它的数出现得更为频繁，由random方法产生的数字有2/3
     *   落在随机数取值范围的前半部分；
     * 3.在极少数情况下，它的失败是灾难性的，返回一个落在指定范围之外的数。之所以如此，是因为这个方法试
     *   图通过调用Math.abs，将rnd.nextInt()返回的值映射为一个非负整数int。如果nextInt()返回
     *   Integer.MIN_VALUE，那么Math.abs也会返回Integer.MIN_VALUE，假设n不是2的乘方，那么取模操作符(%)
     *   将返回一个负数，这几乎肯定会使程序失败，而且这种失败很难重现。
     * 推荐使用Random.nextInt(int)
     */
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (random(n) < n / 2)
                low++;
        System.out.println(low);
    }
}
