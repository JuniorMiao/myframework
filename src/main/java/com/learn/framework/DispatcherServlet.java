package com.learn.framework;

import com.learn.framework.factory.XmlBeanFactory;
import com.learn.framework.process.View;
import com.learn.framework.process.ViewAdapater;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class DispatcherServlet extends BaseInit {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 获取uri
            String uri = request.getRequestURI();
            Object object = invoke(uri);
            if (object != null) {
                // 渲染
                View view = new ViewAdapater();
                view.render(request,response,object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private Object invoke(String uri) throws Exception {
        // 获取uri-method对应的集合
        Method method = XmlBeanFactory.getMethods().get(uri);
        // 调用方法
        if (method == null) {
            return null;
        }
//        Class<?> clazz = method.getDeclaringClass();
//        return method.invoke(clazz.newInstance());
        // 通过工厂获取实例
        Object instance = beanFactory.getUriBean(uri);
        return method.invoke(instance);
    }
}
