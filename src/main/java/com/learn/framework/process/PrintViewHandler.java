package com.learn.framework.process;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintViewHandler implements ViewHandler {

    // json输出
    @Override
    public void print(HttpServletResponse response, Object result) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(JSONObject.toJSONString(result));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
