package com.learn.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewHandler {

    // json输出
    default void print(HttpServletResponse response, Object result) {}

    // 转发
    default void forward(HttpServletRequest request, HttpServletResponse response, Object result){}
}
