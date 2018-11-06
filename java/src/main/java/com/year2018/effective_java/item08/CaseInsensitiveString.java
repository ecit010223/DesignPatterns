package com.year2018.effective_java.item08;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zyh
 * Date: 2018/10/18 18:00
 * Broken - violates symmetry!
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        if (o instanceof String) // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    // 下面为正确的版本
//    @Override
//    public boolean equals(Object o) {
//        return o instanceof CaseInsensitiveString &&
//                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        //cis.equals(s)返回true。问题在于，虽然CaseInsensitiveString类中的equals方法知道普通的字符串
        //（String）对象，但是，String类中的equals方法却并不知道不区分大小字的字符串。因此，
        // s.equals(cis)返回false，显然违反了对称性。
        System.out.println(cis.equals(s) + "  " + s.equals(cis));
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        //如下可能会返回false
        list.contains(cis);
    }
}
