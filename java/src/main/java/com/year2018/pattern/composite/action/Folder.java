package com.year2018.pattern.composite.action;

import java.util.Iterator;
import java.util.List;

/**
 * Author: zyh
 * Date: 2018/8/29 13:45
 */
public class Folder extends Dir {
    public Folder(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        dirs.add(dir);
    }

    @Override
    public void rmDir(Dir dir) {
        dirs.remove(dir);
    }

    @Override
    public void clear() {
        dirs.clear();
    }

    @Override
    public void print() {
        System.out.println(getName()+"(");
        Iterator<Dir> iterator = dirs.iterator();
        while(iterator.hasNext()){
            Dir dir = iterator.next();
            dir.print();
            if(iterator.hasNext()){
                System.out.println(", ");
            }
        }
        System.out.println(")");
    }

    @Override
    public List<Dir> getFiles() {
        return dirs;
    }
}
