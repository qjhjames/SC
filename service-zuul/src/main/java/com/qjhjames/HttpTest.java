package com.qjhjames;

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
 * Created by user on 2018/1/16.
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {

        //String apiUrl = "http://jingangtest.yto56.com.cn/stationin/orginfo";

        //String apiUrl = "http://interface.mamayz.com/stationin/orginfo";

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
            xmlBuilder.append("<request><waybillNo>DD9565730952</waybillNo><opCode>1731</opCode><opTime>2018-04-25 08:53:36</opTime><opUserId>15613155616</opUserId><previousStationCode>511004</previousStationCode><orgCode>511004</orgCode><logisticsCode>BLC00001</logisticsCode><stationCode>0000000514</stationCode><customerCode>louxiaoyi</customerCode></request>");
            //加密 b5aVOICdDc60bYtd
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update((xmlBuilder.toString() + "B1pSF1J97hwVOaHA").getBytes("UTF-8"));
            byte[] abyte0 = messagedigest.digest();
            String data_digest = new String(Base64.encodeBase64(abyte0));
            //查询
            String queryString = "logistics_interface=" + URLEncoder.encode(xmlBuilder.toString(), "UTF-8")
                    + "&data_digest=" + URLEncoder.encode(data_digest, "UTF-8")
                    + "&customer_code=" + URLEncoder.encode("louxiaoyi", "UTF-8")
                    + "&station_type="+ URLEncoder.encode("5501", "UTF-8")
                    + "&op_code="+ URLEncoder.encode("1731", "UTF-8")
                    + "&org_code="+ URLEncoder.encode("511004", "UTF-8");
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



   /* public static  void main(String[] args){
        Jedis jedis = null;
        try{
            jedis = JedisPoolStore.getInstance().getJedis("10.1.193.187",7513);

            //System.out.println(jedis.get("ORG-HOUSEKEEPER-9999999999"));


            //jedis.set("qwerasdfzxcvbnbvbv","0");

            jedis.incr("qwerasdfzxcvbnbvbv12");
            jedis.expire("qwerasdfzxcvbnbvbv12",10);
            if(jedis != null){
                JedisPoolStore.getInstance().returnJedis(jedis);
            }
        }catch(Throwable e){
            if(e instanceof JedisException){
                if (null != jedis)
                    JedisPoolStore.getInstance().returnBrokenJedis(jedis);
            }else{
                if (null != jedis)
                    JedisPoolStore.getInstance().returnJedis(jedis);
            }

            e.printStackTrace();

        }
    }*/



}
