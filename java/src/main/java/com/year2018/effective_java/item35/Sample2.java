package com.year2018.effective_java.item35;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zyh
 * Date: 2018/10/25 16:20
 */
public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Test should pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    } // Should fail (no exception)

    // Code containing an annotation with an array parameter - Page 174
    @ExceptionTest({ IndexOutOfBoundsException.class,NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
