package com.qjhjames.aspect;

import java.lang.annotation.*;

/**
 * Created by qiujunhong on 2018/4/7.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

}
