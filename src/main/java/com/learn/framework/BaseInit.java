package com.learn.framework;

import com.learn.framework.factory.BeanFactory;
import com.learn.framework.factory.XmlBeanFactory;
import com.learn.framework.parse.ParseFile;
import com.learn.framework.parse.ParseXML;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.InputStream;

public class BaseInit extends HttpServlet {

    // 需要通知的对象
    private ParseFile parseFile;

    public BeanFactory beanFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {

//            System.out.println(methods);
            String parameter = config.getInitParameter("contextLocation");
            if (!StringUtils.isEmpty(parameter)) {
                InputStream is = BaseInit.class.getClassLoader().getResourceAsStream(parameter);
                // 执行通知
                parseFile = new ParseXML();
                parseFile.load(is);
                // 实例化工厂
                beanFactory = new XmlBeanFactory();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
