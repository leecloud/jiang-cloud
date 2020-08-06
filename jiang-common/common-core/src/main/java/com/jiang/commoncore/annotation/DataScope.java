package com.jiang.commoncore.annotation;

import java.lang.annotation.*;

/**
 * @ClassName DataScope
 * @Description: 数据权限过滤注解
 * @Author jiang
 * @Date 2020/8/6 23:14
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
