package com.qjhjames.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        IStudent person = (IStudent)ctx.getBean("student");
        person.addStudent("dragon");

        person.delStudent("qjhjames");

        //      person.addStudent("javadragon");
    }
}
