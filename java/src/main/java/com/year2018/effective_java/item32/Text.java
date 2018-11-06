package com.year2018.effective_java.item32;

import java.util.EnumSet;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/25 14:35
 */
public class Text {
    public enum Style {
        BOLD,
        ITALIC,
        UNDERLINE,
        STRIKETHROUGH
    }

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        // Body goes here
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
