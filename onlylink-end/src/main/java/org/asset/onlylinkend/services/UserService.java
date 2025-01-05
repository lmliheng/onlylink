package org.asset.onlylinkend.services;
import org.apache.ibatis.annotations.Param;
import org.asset.onlylinkend.entity.dto.user;
public interface UserService {

    user findByUsername(String username);
    user findByEmail(String email);

    int insertUser(String username, String password,String email);
    boolean isUser(String username);
}


