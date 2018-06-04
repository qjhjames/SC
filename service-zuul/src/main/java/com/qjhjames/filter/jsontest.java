package com.qjhjames.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018/1/24.
 */
public class jsontest {
    public static  void main(String[] args){
        /*Map<String,Object> map=new HashMap<>();
        map.put("2018-01-01",1);
        map.put("2018-01-03",1);
       // String aa=JSONArray.toJSONString(map);

        String version1="v-1.3.0";
        String version2="1.3.0";

        System.out.println(version1.startsWith("v-"));
        System.out.println(version2.startsWith("v-"));

        version1.startsWith("v-");

        String temp="N/1.3";
        String[] t=temp.split("/");
        System.out.println(t[0]);
        System.out.println(t[1]);*/



         System.out.println(getVersionNo("-","\\.","v-1.2.3"));


        System.out.println(getVersionNo("/","\\.","N/1.2"));


    }

   public static double getVersionNo(String regex1,String regex2,String value){
        String[] temp=value.split(regex1);
        String versionTemp=temp[1];
        String[] num=versionTemp.split(regex2);
        String versionNoStr=num[0]+"."+num[1];
        double versionNo=Double.parseDouble(versionNoStr);
        return versionNo;
    }

   /* INSERT INTO T_EXP_STATION_SEND_OUT"
            (ID,LOGISTICS_CODE,CUSTOMER_CODE,STATION_CODE,ORG_CODE,"
    WAYBILL_NO,OP_CODE,OP_USER_ID,OP_TIME,UPLOAD_TIME,WEIGHT,"
    NEXT_ORG_CODE,EMP_CODE,FREQUENCY_NO,RESERVE1,RESERVE2,RESERVE3)"
    VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    INSERT INTO T_EXP_STATION_SEND_GOODS"

    INSERT INTO T_EXP_STATION_SEND_OUT" " +
            "(ID,LOGISTICS_CODE,CUSTOMER_CODE,STATION_CODE,ORG_CODE,"
    WAYBILL_NO,OP_CODE,OP_USER_ID,OP_TIME,UPLOAD_TIME,WEIGHT,"
    NEXT_ORG_CODE,EMP_CODE,FREQUENCY_NO,RESERVE1,RESERVE2,RESERVE3)"
    VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/

 }

