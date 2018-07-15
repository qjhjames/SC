package com.qjhjames.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by qiujunhong on 2018/7/15.
 */
public class CompareInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result = null;
        String stu_name = methodInvocation.getArguments()[0].toString();
        if ( stu_name.equals("dragon")){
            //如果学生是dragon时,执行目标方法,
            result= methodInvocation.proceed();
        } else{
            System.out.println("此学生是"+stu_name+"而不是dragon,不批准其加入.");
        }
        return result;
    }
}
