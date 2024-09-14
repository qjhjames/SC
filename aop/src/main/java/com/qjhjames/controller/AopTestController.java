package com.qjhjames.controller;

import com.qjhjames.aspect.Log;
import com.qjhjames.biz.Biz;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiujunhong on 2018/4/7.
 */
@RestController
public class AopTestController {
    @Autowired
    Biz biz;

    @RequestMapping("/first")
    public String first() {
        System.out.println("come in");
        biz.getInfo();
        return "first controller";
    }


    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }

}

