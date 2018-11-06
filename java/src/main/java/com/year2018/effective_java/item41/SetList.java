package com.year2018.effective_java.item41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: zyh
 * Date: 2018/11/1 10:08
 * 程序会输出[-3,-2,-1][-2,0,2]
 * set.remove(i)调用选择重载方法remove(E)，这里的E是集合(Integer)的元素类型，将i从int自动装箱到Integer
 * 中。另一方面，list.remove(i)调用选择重载方法remove(int i)，它从列表的指定位置上去除元素。如果从列表
 * [-3,-2,-1,0,1,2]开始，去除第零个元素，接着去除第一个、第二个，得到的是[-2,0,2]，可以修改为
 * list.remove(Integer.value(i));  或  list.remove((Integer)i);
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + " " + list);
    }
}
