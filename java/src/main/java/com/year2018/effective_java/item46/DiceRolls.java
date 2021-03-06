package com.year2018.effective_java.item46;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Author: zyh
 * Date: 2018/11/1 16:17
 */
enum Face {
    ONE, TWO, THREE, FOUR, FIVE, SIX
}

public class DiceRolls {
    public static void main(String[] args) {
        Collection<Face> faces = Arrays.asList(Face.values());

        for (Iterator<Face> i = faces.iterator(); i.hasNext();)
            for (Iterator<Face> j = faces.iterator(); j.hasNext();)
                //i.next()会被调用多次
                System.out.println(i.next() + " " + j.next());

        // Preferred idiom for nested iteration on collections and arrays
//        for (Face face1 : faces)
//            for (Face face2 : faces)
//                System.out.println(face1 + " " + face2);
    }
}
