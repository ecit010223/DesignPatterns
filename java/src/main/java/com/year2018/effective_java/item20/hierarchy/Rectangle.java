package com.year2018.effective_java.item20.hierarchy;

/**
 * Author: zyh
 * Date: 2018/10/24 8:44
 */
public class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
