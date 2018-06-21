package com.qjhjames.filter;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by Administrator on 2018/6/12.
 */
public class digestredis {
    //redis主机IP地址
    public static final String HOST = "10.1.193.186";
    //redis主机端口
    public static final Integer PORT = 7328;

    public static void main(String[] args) {
        int count=0;
        Set<String> keyList = getClient().keys("STATIOIN_IN_DATA_12_*");

        for (String key : keyList) {
            String value = getClient().get(key);
            //System.out.println();
            JSONObject object=JSONObject.parseObject(value);
            String time=null;
            if(object!=null){
                time=object.getString("uploadTime");
            }
            if(time!=null&&time.indexOf("2018-06-12")>-1){
                // Long l = getClient().rpush("STATIOIN_IN_DATA_LIST", value);

                count++;
                System.out.println(value);

            }

        }
        System.out.println(keyList.size());
        System.out.println(count);
    }
    public static Jedis jedis = null;

    public static Jedis getClient(){
        if(jedis == null){
            jedis = new Jedis(HOST, PORT);
        }
        return jedis;
    }
}
