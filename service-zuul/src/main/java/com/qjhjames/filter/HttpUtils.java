package com.qjhjames.filter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * get\post请求工具类
 * 
 * @author XieXiCai
 * @created 2014-6-4下午10:59:03
 */
public class HttpUtils {
	
	/**
	 * 发送 get请求
	 * @param host
	 * @param param
	 * @param encoding 参数编码
	 * @param decoding 返回结果编码
	 * @return
	 */
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
	
	/**
	 * 发送post请求
	 * @param host
	 * @param param
	 * @param encoding
	 * @param decoding
	 * @return
	 */
	public static String sendPostReq(String host, String param, String encoding, String decoding) throws Exception{
		String result = "";
		BufferedReader reader = null;
		InputStream inputStream = null;
		
		try {
			URL url = new URL(host);
			// 打开和URL之间的连接
			URLConnection conn = url.openConnection();	
			// 发送POST请求必须设置
            conn.setDoOutput(true);  					
            // 获取URLConnection对象对应的输出流  
            conn.getOutputStream().write(isEmpty(encoding) ? param.getBytes("utf-8") : param.getBytes(encoding));
            // flush输出流的缓冲  
            conn.getOutputStream().flush(); 	 	
            conn.getOutputStream().close();
            
            // 解析返回结果
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

	/**
	 * 发送post请求
	 * @param host
	 * @param param
	 * @param encoding
	 * @param decoding
	 * @return
	 */
	public static String sendJsonPostReq(String host, String param, String encoding, String decoding) throws Exception{
		String result = "";
		BufferedReader reader = null;
		InputStream inputStream = null;

		try {
			URL url = new URL(host);
			// 打开和URL之间的连接
			URLConnection conn = url.openConnection();
			// 发送POST请求必须设置
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type","application/json");
			// 获取URLConnection对象对应的输出流
			conn.getOutputStream().write(isEmpty(encoding) ? param.getBytes("utf-8") : param.getBytes(encoding));
			// flush输出流的缓冲
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			// 解析返回结果
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

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 * @author XieXiCai
	 * @created 2016年10月12日下午8:52:55
	 */
	private static boolean isEmpty(String str){
		if(str == null || "".equals(str))
			return true;
		return false;
	}
}

