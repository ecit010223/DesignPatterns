package com.year2018.effective_java.item67;

import java.util.HashSet;

/**
 * Author: zyh
 * Date: 2018/11/6 9:17
 */
public class Test2 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23)
                    s.removeObserver(this);
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
