package com.qjhjames.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by qiujunhong on 2018/4/7.
 */
@Aspect
@Component
public class LogAspect {

    @Around(value = "@annotation(com.qjhjames.aspect.Log)")
    public Object logInfo(ProceedingJoinPoint proceedingJoinPoint){

        System.out.println("方法环绕start.....");
        try {
            Object o =  proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            //return o;
        } catch (Throwable e) {
            e.printStackTrace();
            //return null;
        }finally {
            System.out.println("结束了.....");
        }
        return  null;
    }
}
