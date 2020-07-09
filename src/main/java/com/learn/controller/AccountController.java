package com.learn.controller;

import com.learn.domain.User;
import com.learn.framework.util.RequestMapping;
import com.learn.service.AccountService;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.controller.AccountController
 ****/
public class AccountController {

    private AccountService accountService;

    /***
     * 查询一条记录
     */
    @RequestMapping(value = "/account/one")
    public String one(){
        System.out.println("执行了one!");
//        String result = null;
        accountService.one();
        return "/WEB-INF/pages/one.jsp";
    }

    /***
     * 查询一条记录
     */
    @RequestMapping(value = "/account/info")
    public User info(){
        User user = new User();
        user.setName("王五");
        user.setAddress("深圳");
        return user;
    }
}
