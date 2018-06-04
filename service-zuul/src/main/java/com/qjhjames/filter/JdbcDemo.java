package com.qjhjames.filter;

import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/5/29.
 */
public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        List<JSONObject> JO=new ArrayList<>();
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        String url = "jdbc:mysql://10.1.240.101:3306/smdm?"
                + "user=ytsmdm&password=p0bqSIlR&useUnicode=true&characterEncoding=UTF8";
        Connection conn = null;
        try {
            // 加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            conn = DriverManager.getConnection(url);
            // 创建statement语句，
            // Statement接口提供了三种执行SQL语句的方法：executeQuery、executeUpdate和execute
            Statement stmt = conn.createStatement();
//          sql = "create table student(id char(20),name varchar(20),primary key(id))";
            // executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//          int rows = stmt.executeUpdate(sql);
//          System.out.println(rows);
//          if (rows != -1) {

            //遍历每一条数据记录
            String sql="select i.station_code,i.station_name,i.station_mobile,i.station_tel,s.sms_mobile from t_mdm_station_info i left JOIN t_mdm_sms_content s on (i.id=s.station_id) and i.customer_code='vzjkxsod' and i.status='VALID'";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                JSONObject object=new JSONObject();
                object.put("station_code",rs.getString("station_code"));
                object.put("station_name",rs.getString("station_name"));
                object.put("station_mobile",rs.getString("station_mobile"));
                object.put("station_tel",rs.getString("station_tel"));
                object.put("sms_mobile",rs.getString("sms_mobile"));
                JO.add(object);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("类未找到异常");
            e.printStackTrace();
        } catch (SQLException e) {
            // try {
            // throw new Exception("异常");
            // } catch (Exception e1) {
            // e1.printStackTrace();
            // }
            e.printStackTrace();
        } finally {
            conn.close();
        }
        int i=0;
        for (JSONObject r:JO){
            boolean station_mobile=true;
            boolean station_tel=true;
            boolean sms_mobile=true;
            if(r.getString("station_mobile")!=null&&!"".equals(r.getString("station_mobile"))){
                if(!istele(r.getString("station_mobile"))){
                    station_mobile=false;
                }
            }
          /*  if(r.getString("station_tel")!=null&&!"".equals(r.getString("station_tel"))){
                if(!istele(r.getString("station_tel"))){
                    station_tel=false;
                }
            }*/
            if(r.getString("sms_mobile")!=null&&!"".equals(r.getString("sms_mobile"))){
                if(!istele(r.getString("sms_mobile"))){
                    sms_mobile=false;
                }
            }

          if(station_mobile&&station_tel&&sms_mobile){

          }else{
              System.out.println(r.toJSONString());
              i++;
          }
        }
        System.out.println(i);
    }

    public static boolean istele(String value) {
        Pattern pattern = Pattern.compile("^((0|8)[0-9]{2,3}-?[0-9]{7,8})|^(((\\\\+86)|(86))?1[0-9]{10})");
        Matcher m = pattern.matcher(value);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
