package com.qjhjames.biz;

import com.qjhjames.aspect.Log;
import org.springframework.stereotype.Component;

/**
 * Created by qiujunhong on 2018/4/7.
 */
@Component
public class Biz extends FatherBiz{

    @Log
    public String getInfo(){
        System.out.println("进入BIZ了......");


        return "aaa";
    }
}
