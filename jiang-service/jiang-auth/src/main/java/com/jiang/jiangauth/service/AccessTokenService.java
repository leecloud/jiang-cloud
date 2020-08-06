package com.jiang.jiangauth.service;

import cn.hutool.core.util.IdUtil;
import com.jiang.commoncore.core.constant.Constants;
import com.jiang.commonredis.util.RedisUtils;
import com.jiang.system.domain.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AccessTokenService
 * @Description: token业务层
 * @Author jiang
 * @Date 2020/8/6 16:58
 **/
@Service("accessTokenService")
public class AccessTokenService {
    @Resource
    RedisUtils redisUtils;
    /**
     * 过期时间12小时
     */
    private final static long EXPIRE = 12*60*60;
    /**
     * token关键字头部
     */
    private final static String ACCESS_TOKEN = Constants.ACCESS_TOKEN;

    private final static String ACCESS_USERID = Constants.ACCESS_USERID;

    /**
     * 根据token`从缓存中获取token
     * @param token token
     * @return SysUser
     */
    public SysUser queryToken(String token){
        return redisUtils.get(ACCESS_TOKEN + token, SysUser.class);
    }

    /**
     * 根据用户对象创建token
     * @param sysUser
     * @return
     */
    public Map<String, Object> createToken(SysUser sysUser){
        String token = IdUtil.fastSimpleUUID();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",sysUser.getUserId());
        map.put("token",token);
        map.put("expire",EXPIRE);
        redisUtils.set(ACCESS_TOKEN + token, sysUser, EXPIRE);
        redisUtils.set(ACCESS_USERID + sysUser.getUserId(), token, EXPIRE);
        return map;
    }

    /**
     * 根据用户id删除缓存
     * @param userId
     */
    public void expireToken(Long userId){
        String token = redisUtils.get(ACCESS_TOKEN + userId);
        if (StringUtils.isNotBlank(token)){
            redisUtils.delete(ACCESS_TOKEN + token);
            redisUtils.delete(ACCESS_USERID + userId);
        }
    }
}
