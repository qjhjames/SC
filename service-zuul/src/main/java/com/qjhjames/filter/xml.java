package com.qjhjames.filter;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public class xml {
    public static void main(String[] args){
        int floor=1;
        String aa="<Response>" +
                "  <logisticProviderId>YTO</logisticProviderId>" +
                "  <code>200</code>" +
                "  <success>true</success>" +
                "  <orderMessages>" +
                "    <orderMessage>" +
                "      <mailNo>B90000515445</mailNo>" +
                "      <isBNet>A</isBNet>" +
                "      <branchOrgCode></branchOrgCode>" +
                "      <branchOrgName></branchOrgName>" +
                "    </orderMessage>" +
                "  </orderMessages>" +
                "  <clientID>K21000119</clientID>" +
                "  <txLogisticID>2018011006sdlkfjld291a</txLogisticID>" +
                "</Response>";
        Document document=null;
        try {
            document=DocumentHelper.parseText(aa);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        // iterate through child elements of root
        //创建解析器

        Element root = document.getRootElement();

        Element next1=root.element("orderMessages");
        Element next2=next1.element("orderMessage");

        System.out.println(next2.elementText("mailNo"));

    }
}
