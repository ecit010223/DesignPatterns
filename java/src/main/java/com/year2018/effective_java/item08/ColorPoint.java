package com.year2018.effective_java.item08;

import java.awt.Color;
import java.awt.Point;

/**
 * Author: zyh
 * Date: 2018/10/18 19:55
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // 方式一：违反对称性
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    // 方式二：Broken - violates transitivity!
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        // If o is a normal Point, do a color-blind comparison
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        // o is a ColorPoint; do a full comparison
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    public static void main(String[] args) {
        // 方式一 equals function violates symmetry
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        // p.equals(cp)返回true，cp.equals(p)则返回false
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // 方式二 equals function violates transitivity
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        // p1.equals(p2)和p2.equals(p3)都返回true，但是p1.equals(p3)则返回false
        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
                p1.equals(p3));
    }
}
