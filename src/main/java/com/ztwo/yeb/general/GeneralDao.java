package com.ztwo.yeb.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author ZTwo
 * @Date 2021/9/11 9:53
 */
public interface GeneralDao<T> extends Mapper<T>, MySqlMapper<T> {
}
