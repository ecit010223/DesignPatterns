package com.year2018.pattern.factory.action;

/**
 * author：zyh
 * on: 2018/8/1 19:50
 */
public abstract class IOHandler {
    public abstract void add(String id,String name);

    public abstract void remove(String id);

    public abstract void update(String id,String name);

    public abstract String query(String id);
}
