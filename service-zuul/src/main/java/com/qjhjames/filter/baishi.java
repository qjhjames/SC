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
 * Created by Administrator on 2018/5/3.
 */
public class baishi {
    public static void main(String[] args) throws Exception {

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
                    "<gloryNo></gloryNo>" +
                    "<stationName>白云大道北128号肯德基妈妈店</stationName>" +
                    "<stationBelongProv>440000</stationBelongProv>" +
                    "<stationBelongCity>440100</stationBelongCity>" +
                    "<stationBelongCounty>440111</stationBelongCounty>" +
                    "<stationAddress>白云大道北128号</stationAddress>" +
                    "<empCode>00345729</empCode>" +
                    "<empMngCode>13621210202</empMngCode>" +
                    "<orgCode>999999</orgCode>" +
                    "<positionCode>0700</positionCode>" +
                    "<operateCode>0100</operateCode>" +
                    "<businessTime>08:30-20:30</businessTime>" +
                    "<stationMobile>18311839292</stationMobile>" +
                    "<expType>10</expType>" +
                    "<stationType>5501</stationType>" +
                    "<logisticsCode>BLC00001</logisticsCode>" +
                    "<customerCode>SX4cwHAT</customerCode>" +
                    "</request>");

            xmlBuilder.append("<request>" +
                    "<waybillNo>12345672123123890</waybillNo>" +
                    "<opCode>1730</opCode>" +
                    "<opTime>2015-07-15 00:00:00</opTime>" +
                    "<opUserId>13621210202</opUserId>" +
                    "<previousOrgCode>999999</previousOrgCode>" +
                    "<empCode>00345729</empCode>" +
                    "<frequencyNo>Z001</frequencyNo>" +
                    "<orgCode>999999</orgCode>" +
                    "<logisticsCode>BLC00001</logisticsCode>" +
                    "<stationCode>0000000526</stationCode>" +
                    "<customerCode>SX4cwHAT</customerCode>" +
                    "<reserve1>reserve</reserve1>" +
                    "<reserve2>reserve</reserve2>" +
                    "<reserve3>reserve</reserve3>" +
                    "</request>");

            xmlBuilder.append("<request>" +
                    "<waybillNo>12345672123123890</waybillNo>" +
                    "<opCode>1745</opCode>" +
                    "<opTime>2015-07-15 00:00:00</opTime>" +
                    "<opUserId>13621210202</opUserId>" +
                    "<orgCode>999999</orgCode>" +
                    "<recieverSigNoff>李四</recieverSigNoff>" +
                    "<deliveryFallReasonCode></deliveryFallReasonCode>" +
                    "<deliveryFallReason></deliveryFallReason>" +
                    "<logisticsCode>BLC00001</logisticsCode>" +
                    "<stationCode>0000000526</stationCode>" +
                    "<customerCode>SX4cwHAT</customerCode>" +
                    "<recieverPhone>13600000000</recieverPhone>" +
                    "<reserve1>reserve</reserve1>" +
                    "<reserve2>reserve</reserve2>" +
                    "<reserve3>reserve</reserve3>" +
                    "</request>");
            //加密 b5aVOICdDc60bYtd
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "cSYLTqDmTKRMHhU4").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));
            //查询
            String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&customer_code=" + URLEncoder.encode("SX4cwHAT", "UTF-8")
                    + "&station_type="+ URLEncoder.encode("5501", "UTF-8")
                    + "&op_code="+ URLEncoder.encode("1745", "UTF-8")
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
