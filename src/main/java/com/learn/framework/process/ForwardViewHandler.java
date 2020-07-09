package com.learn.framework.process;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardViewHandler implements ViewHandler {

    // 转发
    @Override
    public void forward(HttpServletRequest request, HttpServletResponse response, Object result){
        try {
            request.getRequestDispatcher(result.toString()).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
