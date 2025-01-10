package org.asset.onlylinkend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.asset.onlylinkend.entity.dto.userInfo;

@Mapper
public interface UserInfoMapper extends BaseMapper<userInfo> {
    @Select("select id,username,email,avatar,bio,QQ,wechat,github,gitee,personal_website_1,personal_website_2,personal_website_3,personal_website_4 from user where username=#{username}")
    userInfo SelectUserInfoByUsername(String username);

}
