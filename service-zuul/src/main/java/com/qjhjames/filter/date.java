package com.qjhjames.filter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/24.
 */
public class date {

    public static  void main(String[] args){
        SimpleDateFormat f = new SimpleDateFormat("MMddHHmmss");
        String date = f.format(new Date());
        System.out.println(date);
    }
}
