package com.qjhjames.filter;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.servlet.http.HttpUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by user on 2018/1/23.
 */
public class httptest2 {
    public static  void main(String[] args) throws Exception {
    String content= "{'orderChannelCode':'vzjkxsod','recipientAddress':'双建路70号','recipientCityName':'成都市','recipientCountyName':'成华区','recipientProvName':'四川省','senderAddress':'永定门西街5号','senderCityName':'北京市','senderCountyName':'西城区','senderProvName':'北京'}";
    String dataDigest = doSign(content, "utf-8",
            "mOQtvOUghQgo");
    String param = "output_data_type=json&input_data_type=json"
            + "&logistic_provider_id=" + "MMYZ"
            + "&msg_type=" + "TMS_WAYBILL_DISTRIBUTE_INFO_CALC"
            + "&data_digest=" + URLEncoder.encode(dataDigest, "utf-8")
            + "&logistics_interface="
            + URLEncoder.encode(content, "utf-8");
    // 使用get请求
    String response = sendGetReq("http://10.1.5.65/sort/pac_message_receiver.do?", param, "",
            "utf-8");
    // 返回结果转实体
    System.out.println(response);


}

    public static String doSign(String content, String charset, String keys) throws Exception{
        content = content + keys;
        System.out.println("content:"+content);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(content.getBytes(charset));
        String str = new String(Base64.encodeBase64(md.digest()), charset);
        System.out.println("serverDigest:"+str);
        return str;
    }


    public static String sendGetReq(String host, String param, String encoding, String decoding) throws Exception{
        String result = "";
        BufferedReader reader = null;
        InputStream inputStream = null;

        try {
            param = param == null ? "" :param;
            param = isEmpty(encoding) ? param : URLEncoder.encode(param, encoding);

            URL url = new URL(host + param);
            URLConnection conn = url.openConnection();
            inputStream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream,  decoding));

            String line = null;
            while((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(reader != null) reader.close();
            if(reader != null) inputStream.close();
        }
        return result;
    }

    private static boolean isEmpty(String str){
        if(str == null || "".equals(str))
            return true;
        return false;
    }
}
