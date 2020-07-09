package com.learn.service.impl;

import com.learn.dao.AccountDao;
import com.learn.service.AccountService;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.service.impl.AccountServiceImpl
 ****/
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public String one() {
        System.out.println("AccountServiceImpl.one()方法执行");
        return accountDao.one();
    }
}
