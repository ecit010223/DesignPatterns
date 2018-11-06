package com.year2018.effective_java.item39;

import java.util.Date;

/**
 * Author: zyh
 * Date: 2018/10/31 16:54
 */
public class Attack {
    public static void main(String[] args) {
        // 攻击1：Attack the internals of a Period instance - Page 185
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78); // Modifies internals of p!
        System.out.println(p);

        // 攻击2：Second attack on the internals of a Period instance - Page 186
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        p.end().setYear(78); // Modifies internals of p!
        System.out.println(p);
    }
}
