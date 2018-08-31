package com.qjhjames.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class AfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("这是AfterAdvice类的afterReturning方法");//分支test hahah
    }
}
