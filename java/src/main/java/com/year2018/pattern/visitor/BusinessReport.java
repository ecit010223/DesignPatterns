package com.year2018.pattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * author：zyh
 * on: 2018/8/22 21:21
 * 员工业务报表1类
 */
public class BusinessReport {
    List<Staff> mStaffs = new LinkedList<>();

    public BusinessReport(){
        mStaffs.add(new Engineer("王经理"));
        mStaffs.add(new Engineer("工程师-Shawn.Xiong"));
        mStaffs.add(new Engineer("工程师-Kael"));
        mStaffs.add(new Engineer("工程师-Chaossss"));
        mStaffs.add(new Engineer("工程师-Tiiime"));
   }

    /**
     * 为访问者展示报表
     * @param visitor 公司高层，如CEO、CTO
     */
   public void showReport(Visitor visitor){
       for (Staff staff:mStaffs){
           staff.accept(visitor);
       }
   }
}
