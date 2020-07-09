package com.learn.framework.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 代理增强类
public class BeforeProxyBean implements InvocationHandler{

    // 被代理的对象
    private Object instance;

    // 增强的实例
    private Object beforeInstance;

    // 增强的方法
    private Method beforeMethod;

    // 构造方法
    public BeforeProxyBean(Object instance, Object beforeInstance, Method beforeMethod) {
        this.instance = instance;
        this.beforeInstance = beforeInstance;
        this.beforeMethod = beforeMethod;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强
        beforeMethod.invoke(beforeInstance);
        // 目标方法调用
        return method.invoke(instance);
    }
}
