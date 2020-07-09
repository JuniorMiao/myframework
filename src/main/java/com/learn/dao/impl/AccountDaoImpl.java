package com.learn.dao.impl;

import com.learn.dao.AccountDao;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.dao.impl.AccountDaoImpl
 ****/
public class AccountDaoImpl implements AccountDao{

    /**
     * 查询
     */
    @Override
    public String one() {
        System.out.println("Dao查询！");
        return "ok";
    }
}
