package com.year2018.pattern.iterator.advance;

/**
 * author：zyh
 * on: 2018/8/21 22:17
 */
public class CompanyHui implements Company{
    private Employee[] array = new Employee[3];

    public CompanyHui(){
        array[1] = new Employee("辉哥",108,"男","程序猿");
        array[2] = new Employee("小红",98,"男","程序猿");
        array[3] = new Employee("小辉",88,"男","程序猿");
    }

    public Employee[] getEmployees(){
        return array;
    }

    @Override
    public Iterator iterator() {
        return new HuiIterator(array);
    }
}
