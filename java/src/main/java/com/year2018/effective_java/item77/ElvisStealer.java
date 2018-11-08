package com.year2018.effective_java.item77;

import java.io.Serializable;

/**
 * Author: zyh
 * Date: 2018/11/7 10:20
 * 盗用者类
 */
public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        // Save a reference to the "unresolved" Elvis instance
        impersonator = payload;

        // Return an object of correct type for favorites field
        return new String[] { "A Fool Such as I" };
    }

    private static final long serialVersionUID = 0;
}
