package com.learn.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
    // 渲染
    void render(HttpServletRequest request, HttpServletResponse response, Object result);
}
