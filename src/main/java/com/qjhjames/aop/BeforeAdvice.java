package com.qjhjames.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(" 这是BeforeAdviceL类的before方法");
    }
}
