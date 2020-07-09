package com.learn.framework.aop;

// 增强类
public class TransactionManager {

    // 前置增强
    public void begin() {
        System.out.println("开始事务");
    }
}
