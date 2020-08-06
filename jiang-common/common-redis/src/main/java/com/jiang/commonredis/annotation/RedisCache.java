package com.jiang.commonredis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName RedisCache
 * @Description: redis自定义缓存注解
 * @Author jiang
 * @Date 2020/8/6 17:45
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

    /**
     * 键名
     * @return String
     */
    String key() default "";

    /**
     * 主键
     * @return String
     */
    String fieldKey();

    /**
     * 过期时间
     * @return long
     */
    long expired() default 3600;

    /**
     * 是否为查询操作
     * 如果为写入数据库的操作，该值需置为 false
     * @return boolean
     */
    boolean read() default true;
}
