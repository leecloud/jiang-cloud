package com.jiang.log.annotation;

import com.jiang.log.enums.BusinessType;
import com.jiang.log.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @ClassName OperLog
 * @Description: 自定义日志注解
 * @Author jiang
 * @Date 2020/8/6 21:22
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
