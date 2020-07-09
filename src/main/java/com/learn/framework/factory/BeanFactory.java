package com.learn.framework.factory;

public interface BeanFactory {
    // 根据Id获取实例
    Object getBean(String id);

    // 根据uri获取实例
    Object getUriBean(String uri);
}
