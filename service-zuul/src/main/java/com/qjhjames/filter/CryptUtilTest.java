package com.qjhjames.filter;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by wangrui on 2017/8/11.
 */
public class CryptUtilTest {
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    /**
     * 校验签名
     *
     * @param sign   签名
     * @param map    数据
     * @param rsaKey 签名key
     * @return
     */
    public static boolean checkSign(String sign, Map map, String rsaKey) {
        boolean result = false;
        SortedMap<Object, Object> sortedMap = new TreeMap<Object, Object>();
        if (map instanceof Map) {
            Set set = map.keySet();
            Iterator it = set.iterator();
            for (; it.hasNext(); ) {
                String key = (String) it.next();
                sortedMap.put(key, map.get(key));
            }
        }
        String signKey = createSign(sortedMap, rsaKey);
        if (sign.equals(signKey)) {
            result = true;
        }
        return result;
    }

    /**
     * 签名算法sign
     *
     * @param parameters 参数
     * @param rsaKey     签名key
     * @return
     */
    public static String createSign(SortedMap<Object, Object> parameters, String rsaKey) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + rsaKey);
        String characterEncoding = "UTF-8";
        String sign = MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }


    public static void main(String[] args) throws Exception {
        String key = "reywong";
        SortedMap sortedMap = new TreeMap();
        sortedMap.put("vip_userid", "0001");
        sortedMap.put("einvoice_invoice_page", "1");
        sortedMap.put("einvoice_invoice_page", "einvoice_invoice_pagesize");
        System.out.println(CryptUtilTest.createSign(sortedMap, key));

    }
}


