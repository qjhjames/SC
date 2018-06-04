package com.qjhjames.filter;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2018/4/26.
 */
public class httptest0002 {
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
                    "<stationCode>0000012181</stationCode>" +
                    "<stationBelongProv>021</stationBelongProv>" +
                            "<stationBelongCity>310000</stationBelongCity>" +
                            "<stationBelongCounty>310110</stationBelongCounty>" +
                            "<stationAddress>政通路250号</stationAddress>"+   //021	310000	310110
                    "<opCode>0002</opCode>" +
                    "<orgCode>210045</orgCode>" +
                    "<customerCode>vzjkxsod</customerCode>" +
                    "<smsMobile>13600000004</smsMobile>" +
                    "</request>");

            //加密 b5aVOICdDc60bYtd
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "MiSjEtFKfq9OoySt").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));
            //查询
            String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&customer_code=" + URLEncoder.encode("vzjkxsod", "UTF-8")
                    + "&station_type="+ URLEncoder.encode("5501", "UTF-8")
                    + "&op_code="+ URLEncoder.encode("0002", "UTF-8")
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
