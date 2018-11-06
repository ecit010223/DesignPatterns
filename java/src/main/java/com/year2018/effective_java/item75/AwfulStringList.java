package com.year2018.effective_java.item75;

import java.io.Serializable;

/**
 * Author: zyh
 * Date: 2018/11/6 16:02
 * 如果采用了默认的序列化形式，该序列化形式将不遗余力地境像出链表中的所有项，以及这些项之间的双向链接。
 */
public class AwfulStringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable{
        String data;
        Entry next;
        Entry previous;
    }

    //...
}
