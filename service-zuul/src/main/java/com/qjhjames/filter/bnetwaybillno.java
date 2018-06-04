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
 * Created by Administrator on 2018/5/15.
 */
public class bnetwaybillno {
    public static  void main(String[] args){
        String apiUrl = "http://58.32.246.71:8000/api/dispatch.action";
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
            xmlBuilder.append("<RequestOrder>" +
                    "<clientID>K21000119</clientID>" +
                    "<logisticProviderID>YTO</logisticProviderID>" +
                    "<customerId>K21000119</customerId>" +
                    "<txLogisticID>2018011006sdlkfjld291a</txLogisticID>" +
                    "<serviceType>0</serviceType>" +
                    "<sender>" +
                    "<name>今晨</name>" +
                    "<postCode/>" +
                    "<phone>02161119075</phone>" +
                    "<mobile/>" +
                    "<prov>上海</prov>" +
                    "<city>上海市,闵行区</city>" +
                    "<address>上海市闵行区华漕镇华翔路2239号天地华宇1号仓库</address>" +
                    "</sender>" +
                    "<receiver>" +
                    "<name>李威</name>" +
                    "<postCode/>" +
                    "<phone>15872891875</phone>" +
                    "<mobile/>" +
                    "<prov>上海市</prov>" +
                    "<city>上海市,嘉定区</city>" +
                    "<address>华亭镇</address>" +
                    "</receiver>" +
                    
                    "<remark>你好， 长江</remark>" +
                    "</RequestOrder>");

            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "u2Z1F7Fh").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));
            //查询
            String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&clientId=" + URLEncoder.encode("K21000119", "UTF-8")
                    + "&msg_type="+ URLEncoder.encode("TMS_PULL_TRACKING_NO_BW", "UTF-8")
                    + "&data_type="+ URLEncoder.encode("xml", "UTF-8")
                    + "&version="+ URLEncoder.encode("0.0.1", "UTF-8");
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
