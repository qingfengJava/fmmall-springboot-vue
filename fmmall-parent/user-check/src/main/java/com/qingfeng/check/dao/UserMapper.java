package com.qingfeng.check.dao;

import com.qingfeng.fm.entity.Users;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/14
 */
@Repository
public interface UserMapper extends Mapper<Users>, MySqlMapper<Users> {
}
