package com.learn.framework.parse;

import com.learn.framework.BaseInit;

import java.io.InputStream;

public abstract class ParseFile {
    // 被监听的对象
    private BaseInit baseInit;

    // 执行通知
    public abstract void load(InputStream is);
}
