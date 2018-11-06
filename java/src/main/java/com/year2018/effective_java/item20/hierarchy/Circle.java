package com.year2018.effective_java.item20.hierarchy;

/**
 * Author: zyh
 * Date: 2018/10/24 8:44
 */
public class Circle extends Figure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
