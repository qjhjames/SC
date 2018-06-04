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
 * Created by user on 2018/3/7.
 */
public class httptest3 {
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
            //xmlBuilder.append("<RequestOrder><logisticProviderID>YTO</logisticProviderID><customerId>K21002090</customerId><txLogisticID>EU000004533545</txLogisticID><orderType>1</orderType><acceptCanvassEmpCode>00011448</acceptCanvassEmpCode></RequestOrder>");

            // xmlBuilder.append("<request><waybillNo>700412976244</waybillNo><customerCode>dianwoda</customerCode></request>");

            // xmlBuilder.append("<request><reserve3>reserve</reserve3><reserve2>reserve</reserve2><reserve1>reserve</reserve1><customerCode>dianwoda</customerCode><stationCode>0000000061</stationCode><logisticsCode>BLC00001</logisticsCode><orgCode>999999</orgCode><frequencyNo>Z001</frequencyNo><empCode>00001194</empCode><waybillNo>D10000000111</waybillNo> <opCode>1730</opCode> <opTime>2015-07-15 00:00:00</opTime><opUserId>18721552408</opUserId><previousOrgCode>210045</previousOrgCode></request>");

            //xmlBuilder.append("<request><empCode>01386646</empCode><stationType>5501</stationType><stationBelongProv>350000</stationBelongProv><positionCode>0200</positionCode><logisticsCode>BLC00001</logisticsCode><customerCode>landian</customerCode><empMngCode>13779990808</empMngCode><stationBelongCity>350200</stationBelongCity><stationMobile>13779990808</stationMobile><stationAddress>福建省厦门市湖里区仙岳路680号-7龙门天下南门以琳连锁便利店</stationAddress><stationBelongCounty>350206</stationBelongCounty><empCode>01386646</empCode><orgCode>592021</orgCode><stationName>以琳连锁便利店</stationName><operateCode>0300</operateCode></request>");
            //xmlBuilder.append("<request><stationName>楼小易社区服务站</stationName><stationBelongProv>110000</stationBelongProv><stationBelongCity>110100</stationBelongCity><stationBelongCounty>110105</stationBelongCounty><stationAddress>朝阳区西坝河168号恒川公寓E栋</stationAddress><empCode>00881402</empCode><empMngCode>51078639</empMngCode><orgCode>511004</orgCode><positionCode>0200</positionCode><operateCode>88801</operateCode><stationMobile>51078639</stationMobile><stationType>5501</stationType><logisticsCode>BLC00001</logisticsCode><customerCode>louxiaoyi</customerCode></request>");

            //
            // xmlBuilder.append("<request><customerCode>dianwoda</customerCode><empCode>00000009</empCode><logisticsCode>BLC00001</logisticsCode><opCode>1745</opCode><opTime>2018-04-23 11:18:39</opTime><opUserId>13738000001</opUserId><orgCode>999999</orgCode><previousOrgCode>999999</previousOrgCode><stationCode>0000000061</stationCode><waybillNo>DD9565730952</waybillNo></request>");

            //签收
            xmlBuilder.append("<request>" +
                    "<waybillNo>899931464541</waybillNo>" +
                    "<opCode>1745</opCode>" +
                    "<opTime>2015-07-15 00:00:00</opTime>" +
                    "<opUserId>13648042084</opUserId>" +
                    "<orgCode>210045</orgCode>" +
                    "<recieverSigNoff>李四</recieverSigNoff>" +
                    "<deliveryFallReasonCode></deliveryFallReasonCode>" +
                    "<deliveryFallReason></deliveryFallReason>" +
                    "<logisticsCode>BLC00001</logisticsCode>" +
                    "<stationCode>0000000061</stationCode>" +
                    "<customerCode>dianwoda</customerCode>" +
                    "<recieverPhone>13600000000</recieverPhone>" +
                    "<reserve1>reserve</reserve1>" +
                    "<reserve2>reserve</reserve2>" +
                    "<reserve3>reserve</reserve3>" +
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
