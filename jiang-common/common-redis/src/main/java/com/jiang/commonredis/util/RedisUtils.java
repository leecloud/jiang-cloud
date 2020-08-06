package com.jiang.commonredis.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName RedisUtils
 * @Description: redis工具类
 * @Author jiang
 * @Date 2020/8/6 17:28
 **/
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOperations;
    /**
     * 默认过期时长单位秒
     */
    public final static long DEFAULT_EXPIRE = 60*60*24;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;

    /**
     * 插入缓存过期时间默认
     * @param key
     * @param value
     */
    public void set(String key, Object value){
        set(key,value,DEFAULT_EXPIRE);
    }

    /**
     * 插入缓存
     * @param key key
     * @param value 值
     * @param expire 过期时间
     */
    public void set(String key, Object value, long expire){
        valueOperations.set(key, toJson(value));
        redisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    /**
     * 根据key获取缓存数据返回字符串
     * @param key key
     * @return String
     */
    public String get(String key){
        return valueOperations.get(key);
    }

    /**
     * 回指定类型结果
     * @param key 键值
     * @param clazz 类型class
     * @param <T>
     */
    public <T> T get(String key, Class<T> clazz){
        String value = valueOperations.get(key);
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 根据key删除缓存
     * @param key 键
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     * @param object 对象
     * @return String
     */
    private String toJson(Object object){
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double
                || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }
}
