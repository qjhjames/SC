package com.qjhjames.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/22.
 */
public class yiappladan {


    public static void main(String[] args){
        String host="http://localhost:8080/yiapp-server-station/getThreeCodeAndMailNo";

        try {
            String result=HttpUtils.sendJsonPostReq(host,getRequestRequestBody(),"","utf-8");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static    String DATATYPE="JSON";
    public  static String LOCATION="086";
    public static  String VERSIONNO="v-1.4.0";

    private static String SERIALNO="10f9842e-95d3-403f-9340-454edcd76b4dc";

    private static String MODELNO="BLN-AL30";

    private static String KEY="5ec31b2f-5a50-4c26-8737-0d0b025a541c";

    static String  username="15821848854";

    static  String  empCode="00000011";
    private static   String getRequestRequestBody() {
        Map<String,String> bizParams =new HashMap<String, String>();
        bizParams.put("sourceProvinceName","上海");
        bizParams.put("sourceCityName","上海市");
        bizParams.put("sourceDistrictName","青浦区");
        bizParams.put("sourceAddress","华志璐300号");
        bizParams.put("destProvinceName","上海");
        bizParams.put("destCityName","上海市");
        bizParams.put("destDistrictName","青浦区");
        bizParams.put("destAddress","凤溪小学");
        bizParams.put("sourceCustomer","张苏纳");
        bizParams.put("sourcePhone","13621012323");
        bizParams.put("destCustomer","王晓");
        bizParams.put("destPhone","15625251212");

        String data = EncryptionDecryptionUtils.netEnCoder(EncryptionDecryptionUtils.encryptionByBase64(JSON.toJSONString(bizParams)), "UTF-8");
        String digest = EncryptionDecryptionUtils.encryptionByMD5AndBase64(data + DATATYPE + LOCATION + username + empCode + SERIALNO + MODELNO + VERSIONNO + KEY);
        Map<String, Object> params = new HashMap();
        params.put("data", data);
        params.put("dataType", DATATYPE);
        params.put("digest", EncryptionDecryptionUtils.netEnCoder(digest, "UTF-8"));
        params.put("location", LOCATION);
        params.put("username", username);
        params.put("serialNo", SERIALNO);
        params.put("modelNo", MODELNO);
        params.put("empCode", empCode);
        params.put("versionNo", VERSIONNO);
        String json = JSON.toJSONString(params);
        return json;
    }
}
