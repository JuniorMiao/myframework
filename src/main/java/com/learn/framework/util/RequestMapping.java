package com.learn.framework.util;

import java.lang.annotation.*;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.framework.util.RequestMapping
 ****/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    //定义一个注解的属性，属性名字叫value  default  默认值
    String value() default "";
}
