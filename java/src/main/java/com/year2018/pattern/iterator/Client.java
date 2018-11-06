package com.year2018.pattern.iterator;

/**
 * author：zyh
 * on: 2018/8/21 21:30
 */
public class Client {
    public static void main(String[] args){
        Aggregate<String> a = new ConcreteAggregate<>();
        a.add("Aige");
        a.add("Studio\n");
        a.add("SM");
        a.add(" Brother");
        Iterator<String>  i = a.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
