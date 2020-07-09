package com.learn.framework.parse;

import com.learn.framework.util.XmlBean;

import java.io.InputStream;

public class ParseXML extends ParseFile {

    @Override
    public void load(InputStream is) {
        System.out.println("开始解析XML");
        try {
            XmlBean.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
