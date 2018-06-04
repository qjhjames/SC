package com.qjhjames.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Administrator on 2018/5/21.
 */
public class BNetLadan {
    public static  void main(String[] args){
        String apiUrl = "http://jingangtest.yto56.com.cn/stlresellerbillsoa/stlResellerBillController/getResellerResult";
        try {
            //打开连接
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

           String key = "ytostlbnet";
           //         String key="58x6S8CP";
            SortedMap sortedMap = new TreeMap();
            sortedMap.put("customerCode", "K99902397");//K90000005
            sortedMap.put("price", "20");

            String sign=CryptUtilTest.createSign(sortedMap,key);

            JSONObject object=new JSONObject();

            object.put("customerCode","K99902397");
            object.put("price","20");
            object.put("sign",sign);

           /* MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "dianwoda123").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));*/
            //查询
            String queryString=object.toJSONString();
           /* String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&customer_code=" + URLEncoder.encode("dianwoda", "UTF-8")
                    + "&station_type="+ URLEncoder.encode("5501", "UTF-8")
                    + "&op_code="+ URLEncoder.encode("1730", "UTF-8")
                    + "&org_code="+ URLEncoder.encode("999999", "UTF-8");*/
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
