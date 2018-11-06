package com.year2018.effective_java.item35;

/**
 * Author: zyh
 * Date: 2018/10/25 16:21
 */
public class Sample {
    @Test
    public static void m1() {
    } // Test should pass

    public static void m2() {
    }

    @Test
    public static void m3() { // Test Should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    // 注解使用错误，不是静态方法，因为会无效
    @Test
    public void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() { // Test should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
}
