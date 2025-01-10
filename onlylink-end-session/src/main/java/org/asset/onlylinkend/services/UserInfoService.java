package org.asset.onlylinkend.services;

import org.asset.onlylinkend.entity.dto.userInfo;


public interface UserInfoService {
    userInfo findUserInfoByUsername(String username);

}
