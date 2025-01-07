package org.asset.onlylinkend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.asset.onlylinkend.entity.dto.userInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<userInfo> {
    @Select("select id,username,email from user where username=#{username}")
    userInfo SelectUserInfoByUsername(String username);

}
