package com.year2018.effective_java.item35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: zyh
 * Date: 2018/10/25 16:21
 */
public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Sample2.class;
        for (Method m : testClass.getDeclaredMethods()) {
            //判断该程序元素上是否包含指定类型的注解
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) { //测试方法抛出异常
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {  //捕捉到Test注解的无效用法
                    System.out.println("INVALID @Test: " + m);
                }
            }

            // Array ExceptionTest processing code - Page 174
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) { //检测抛出的异常是否为正确的类型
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation( ExceptionTest.class).value();
                    int oldPassed = passed;
                    //抛出任何一种指定异常时都得到通过
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, exc);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}