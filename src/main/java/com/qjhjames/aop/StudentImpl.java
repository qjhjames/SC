package com.qjhjames.aop;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class StudentImpl implements IStudent {
    @Override
    public void addStudent(String name) {
        System.out.println("欢迎 "+name+" 你加入");
    }

    @Override
    public void delStudent(String name) {
        System.out.println("删除 "+name);
    }
}
