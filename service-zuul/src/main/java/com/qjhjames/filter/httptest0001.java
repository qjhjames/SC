package com.qjhjames.filter;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2018/5/16.
 */
public class httptest0001 {
    public static  void main(String[] args){
        String apiUrl = "http://jingangtest.yto56.com.cn/stationin/post";
        //String apiUrl = "http://localhost:8081/stationin/post";
        try {
            //打开连接
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            //数据
            StringBuilder xmlBuilder = new StringBuilder();



            xmlBuilder.append("<request>" +
                    "<opUserId>13055575103</opUserId>" +
                    "<opUserName>李四</opUserName>" +
                    "<opUserMobile>13055575103</opUserMobile>" +
                    "<opUserPwd>O9azKlzlLcck13</opUserPwd>" +
                    "<status>VALID</status>" +
                    "<empType>employee</empType>" +
                    "<usdTml>false</usdTml>" +
                    "<stationCode>0000000530</stationCode>" +
                    "<logisticsCode>BLC00001</logisticsCode>" +
                    "<customerCode>dianwoda</customerCode>" +
                    "<orgCode>999999</orgCode>" +
                    "<reserve1></reserve1>" +
                    "<reserve2></reserve2>" +
                    "<reserve3></reserve3>" +
                    "</request>");

            //加密 b5aVOICdDc60bYtd
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "dianwoda123").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));
            //查询
            String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&customer_code=" + URLEncoder.encode("dianwoda", "UTF-8")
                    + "&station_type="+ URLEncoder.encode("5501", "UTF-8")
                    + "&op_code="+ URLEncoder.encode("0001", "UTF-8")
                    + "&org_code="+ URLEncoder.encode("999999", "UTF-8");
            System.out.println(queryString);
            out.write(queryString);
            out.flush();
            out.close();
            //获取服务端的反馈
            String responseString = "";
            String strLine = "";
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((strLine = reader.readLine()) != null) {
                responseString += strLine + "\n";
            }
            in.close();
            System.err.print("请求的返回信息：" + responseString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

