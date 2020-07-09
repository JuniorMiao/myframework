package com.learn.framework.aop;

import com.learn.framework.util.XmlBean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

// 创建代理类的工厂
public class ProxyBeanFactory {

    // 将被代理的类进行增强操作
    public static void proxy(Map<String, Object> beans) {
        // 获取前置增强节点信息
        try {
            Map<String, String> map = XmlBean.before();
            if (map == null) {
                return;
            }
            // 获取指定的包
            String packageInfo = map.get("package");
            // 获取增强类实例
            Object aopInstance = beans.get(map.get("ref"));
            // 增强方法
            Method method = aopInstance.getClass().getDeclaredMethod(map.get("method"));
            // 增强操作
            beforeHandler(beans,aopInstance,method,packageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void beforeHandler(Map<String, Object> beans, Object aopInstance, Method method, String packageInfo) throws Exception {
        // 循环增强
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            String entryPackageName = entry.getValue().getClass().getPackage().getName();
            // 增强包下的类，需要增强
            if (entryPackageName.equals(packageInfo)) {
                // 创建代理对象
                Object proxyInstance = Proxy.newProxyInstance(entry.getValue().getClass().getClassLoader(),
                        entry.getValue().getClass().getInterfaces(),
                        new BeforeProxyBean(entry.getValue(), aopInstance, method));
                // 将被代理的对象替换
                beans.put(entry.getKey(),proxyInstance);
                // 将实例对象中对应属性替换成代理对象
                XmlBean.replaceProxy(beans,entry.getKey(),proxyInstance);
            }
        }
    }

}
