package com.jiang.commoncore.core.dao;


import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @ClassName BaseMapper
 * @Description: mapper基类
 * @Author jiang
 * @Date 2020/8/6 15:56
 **/
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, InsertListMapper<T>, ConditionMapper<T> {

}
