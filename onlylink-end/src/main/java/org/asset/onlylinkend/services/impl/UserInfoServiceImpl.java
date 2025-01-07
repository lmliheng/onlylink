package org.asset.onlylinkend.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.asset.onlylinkend.services.UserInfoService;
import org.springframework.stereotype.Service;
import org.asset.onlylinkend.entity.dto.userInfo;
import org.asset.onlylinkend.mapper.UserInfoMapper;
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, userInfo> implements UserInfoService {
    @Override
    public userInfo findUserInfoByUsername(String username) {
        return baseMapper.SelectUserInfoByUsername(username);
    }



}
