package com.learn.framework.factory;

import com.learn.framework.aop.ProxyBeanFactory;
import com.learn.framework.util.ParseAnnotation;
import com.learn.framework.util.XmlBean;
import com.learn.service.AccountService;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;

public class XmlBeanFactory implements BeanFactory {

    // uri-> method
    private static Map<String, Method> methods;
    // id -> instance
    private static Map<String, Object> beans;
    // uri-> id
    private static Map<String, String> uriIdMap;

    public XmlBeanFactory() {
        initBeans();
    }

    public XmlBeanFactory(String config) {
        try {
            InputStream is = XmlBeanFactory.class.getClassLoader().getResourceAsStream(config);
            XmlBean.load(is);
            initBeans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object getBean(String id) {
        return beans.get(id);
    }

    @Override
    public Object getUriBean(String uri) {
        String id = uriIdMap.get(uri);
        if (StringUtils.isNotEmpty(id)) {
            return beans.get(id);
        }
        return null;
    }

    private void initBeans() {
        try {
            methods = ParseAnnotation.parseRequestMapping();
            beans = XmlBean.initBeans();
            // 增强操作
            ProxyBeanFactory.proxy(beans);
            uriIdMap = ParseAnnotation.parseUrlMappingInstance(methods,beans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Method> getMethods() {
        return methods;
    }

    public static Map<String, Object> getBeans() {
        return beans;
    }

    public static Map<String, String> getUriIdMap() {
        return uriIdMap;
    }


    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory("spring.xml");
        AccountService accountService = (AccountService) xmlBeanFactory.getBean("accountService");
        System.out.println(accountService);
    }
}
