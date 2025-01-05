package org.asset.onlylinkend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;
import org.asset.onlylinkend.entity.dto.user;

/**
 * 用户信息 数据库操作接口
 */

@Mapper
public interface UserMapper extends BaseMapper<user> {

    @Select("select * from user where username=#{username}")
    user selectByUsername(String username);

    @Select("select * from user where email=#{email}")
    user selectByEmail(String email);



}
