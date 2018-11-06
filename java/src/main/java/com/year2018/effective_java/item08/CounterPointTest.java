package com.year2018.effective_java.item08;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/18 20:11
 */
public class CounterPointTest {
    // Initialize UnitCircle to contain all Points on the unit circle
    private static final Set<Point> unitCircle;
    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, -1));
    }

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);

        // Prints true
        System.out.println(onUnitCircle(p1));

        // 无论CounterPoint实例的x和y值是什么，onUnitCircle方法都会返回false
        System.out.println(onUnitCircle(p2));
    }
}
