package com.year2018.effective_java.item08.composition;

/**
 * Author: zyh
 * Date: 2018/10/18 20:25
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    // See Item 9
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
