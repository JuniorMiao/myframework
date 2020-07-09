package com.learn.framework.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAdapater implements View {

    private ViewHandler viewHandler;

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, Object result) {
        if (result instanceof String) {
            viewHandler = new ForwardViewHandler();
            viewHandler.forward(request,response,result);
        } else {
            viewHandler = new PrintViewHandler();
            viewHandler.print(response,result);
        }
    }
}
