package com.year2018.effective_java.item11;

/**
 * Author: zyh
 * Date: 2018/10/19 13:41
 */
public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[]{};

    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value,Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Recursively copy the linked list headed by this Entry
         * 虽然这种方法很灵活，如果散列桶不是很长的话，也会工作得很好，但是，这样克隆一个链表并不是一种
         * 好办法，因为针对列表中的每个元素，它都要消耗一段栈空间。如果链表比较长，这很容易导致栈溢出。
         * 为了避免发生这种情况，可以在deepCopy中用迭代代替递归。
         */
//        Entry deepCopy(){
//            return new Entry(key,value,next==null?null:next.deepCopy());
//        }

        //Iteratively copy the linked list headed by this entry
        Entry deepCopy(){
            Entry result = new Entry(key,value,next);
            for(Entry p = result;p.next!=null;p=p.next){
                p.next = new Entry(p.next.key,p.next.value,p.next.next);
            }
            return result;
        }
    }

    /**
     * Broken - results in shared internal state!
     * 虽然被克隆对象有它自己的散列桶数组，但是，这个数组引用的链表与原始对象是一样的，从而很容易引起克
     * 隆对对象和原始对象中不确定的行为。为了修正这个问题，必须单独地拷贝并组成每个桶的链表。
     * 如上在Entry类中添加deepCopy()并修改为新的clone(),见方式二
     */
//    @Override
//    public HashTable clone(){
//        try{
//            HashTable result = (HashTable) super.clone();
//            result.buckets = buckets.clone();
//            return result;
//        }catch (CloneNotSupportedException e){
//            throw new AssertionError();
//        }
//    }

    @Override
    public HashTable clone(){
        try{
            HashTable result = (HashTable)super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i=0;i<buckets.length;i++){
                if(buckets[i]!=null){
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
