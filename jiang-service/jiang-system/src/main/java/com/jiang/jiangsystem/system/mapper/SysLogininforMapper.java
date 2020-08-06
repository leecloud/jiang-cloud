package com.jiang.jiangsystem.system.mapper;

import com.jiang.system.domain.SysLogininfor;

/**
 * @ClassName SysLogininforMapper
 * @Description: 系统访问日志情况信息数据层
 * @Author jiang
 * @Date 2020/8/6 21:40
 **/
public interface SysLogininforMapper {
    /**
     * 新增
     * @param sysLogininfor
     */
    void insertLogininfor(SysLogininfor sysLogininfor);
}
