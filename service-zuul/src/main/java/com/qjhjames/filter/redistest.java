package com.qjhjames.filter;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/23.
 */
public class redistest {
    //redis主机IP地址
    public static final String HOST = "10.1.193.186";
    //redis主机端口
    public static final Integer PORT = 7330;

    public static void main(String[] args) {
    int count=0;
            Set<String> keyList = getClient().keys("STATION_SMS_DATA_12_*");

            for (String key : keyList) {
                String value = getClient().get(key);
                //System.out.println();
                JSONObject object=JSONObject.parseObject(value);
                String time=null;
                if(object!=null){
                    time=object.getString("createTime");
                }
                if(time!=null&&time.indexOf("2018-06-12")>-1){
                   // Long l = getClient().rpush("STATION_SMS_DATA_LIST", value);
                    count++;
                    System.out.println(value);

                }

            }
        System.out.println(keyList.size());
        System.out.println(count);
    }
       // getClient().keys("STATIOIN_IN_DATA_23_16*");

       // System.out.println(getClient().get("STATIOIN_IN_DATA_20_17_sti8a8163e0617b3b200162e24928102b81"));




   /* public static void main(String[] args) {
       *//* int day=23;
        for(int hour=0;hour<24;hour++){
            Set<String> keyList=getClient().keys("STATIOIN_IN_DATA_"+day+"_"+hour+"*");

            for(String key:keyList){
                String value=getClient().get(key);
                Long l=getClient().rpush("STATIOIN_IN_DATA_LIST",value);
                System.out.println(l.toString());
            }
        }*//*

        Set<String> keyList=getClient().keys("STATION_INFO*");
        for(String key:keyList){
            getClient().del(key);
            System.out.println(key);
        }



        System.out.println(keyList.size());

        // getClient().keys("STATIOIN_IN_DATA_23_16*");

        // System.out.println(getClient().get("STATIOIN_IN_DATA_20_17_sti8a8163e0617b3b200162e24928102b81"));
    }*/


    public static Jedis jedis = null;

    public static Jedis getClient(){
        if(jedis == null){
            jedis = new Jedis(HOST, PORT);
        }
        return jedis;
    }
}
