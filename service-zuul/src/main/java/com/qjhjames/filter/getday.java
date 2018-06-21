package com.qjhjames.filter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
public class getday {
    public static void main(String[] args){

            Date date=new Date();
            Calendar ca=Calendar.getInstance();
            ca.setTime(date);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

            String st=sdf.format(date);
            int i=ca.get(Calendar.DAY_OF_YEAR);
            int a=ca.get(Calendar.DAY_OF_MONTH);
            System.out.println("当前时间是："+st+";一年中的"+i+"一个月中的"+a);

            Map map=new HashMap<String,Object>();
            map.put("a","b");
    }
}



























